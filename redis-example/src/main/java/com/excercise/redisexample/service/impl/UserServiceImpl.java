package com.excercise.redisexample.service.impl;

import com.excercise.redisexample.model.dto.AddUserDTO;
import com.excercise.redisexample.model.dto.AuthUserDTO;
import com.excercise.redisexample.model.dto.GenericResponse;
import com.excercise.redisexample.model.entity.RedisUser;
import com.excercise.redisexample.service.RedisUtility;
import com.excercise.redisexample.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RedisUtility redisUtility;

    @Override
    public GenericResponse addUser(AddUserDTO addUserDTO) {
        RedisUser redisUser = new RedisUser();
        redisUser.setEmailId(addUserDTO.getEmail());
        redisUser.setPassword(addUserDTO.getPassword());
        redisUser.setId(UUID.randomUUID());
        redisUtility.setValue("user"  ,redisUser);
        redisUser.setId(UUID.randomUUID());
        redisUtility.setValue("user:1",redisUser);
        return new GenericResponse("User Successfully Recieved.", redisUser);
    }

    @Override
    public GenericResponse authUser(AuthUserDTO authUserDTO) {
        return null;
    }

    @Override
    public GenericResponse getKey(String key) {
        TypeReference<RedisUser> typeRef = new TypeReference<>(){};
        RedisUser user = redisUtility.getValue(key, typeRef);
        return new GenericResponse("Us312312", user);
    }
}
