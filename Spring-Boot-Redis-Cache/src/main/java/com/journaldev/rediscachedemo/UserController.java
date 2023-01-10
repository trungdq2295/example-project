package com.journaldev.rediscachedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/get-all")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Cacheable(value = "users", key = "#userId")
    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        LOG.info("Getting user with ID {}.", userId);
        return userRepository.findById(userId).orElse(new User());
    }

    @CachePut(value = "users", key = "#user.id")
    @PutMapping("/update")
    public User updatePersonByID(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @CacheEvict(value = "users", allEntries=true)
    @DeleteMapping("/{userId}")
    public void deleteUserByID(@PathVariable Long userId) {
        LOG.info("deleting person with id {}", userId);
        userRepository.deleteById(userId);
    }
}
