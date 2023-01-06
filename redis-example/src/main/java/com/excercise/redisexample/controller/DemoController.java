package com.excercise.redisexample.controller;

import com.excercise.redisexample.model.dto.AddUserDTO;
import com.excercise.redisexample.model.dto.GenericResponse;
import com.excercise.redisexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis/demo")
public class DemoController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public GenericResponse addUser(@RequestBody AddUserDTO addUserDTO) {
        return userService.addUser(addUserDTO);
    }

    @GetMapping("/get-user")
    public GenericResponse getUser(@RequestParam String key) {
        return userService.getKey(key);
    }
}
