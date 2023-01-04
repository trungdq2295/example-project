package com.excercise.redisexample.service;

import com.excercise.redisexample.model.dto.AddUserDTO;
import com.excercise.redisexample.model.dto.AuthUserDTO;
import com.excercise.redisexample.model.dto.GenericResponse;

public interface UserService {

    GenericResponse addUser(AddUserDTO addUserDTO);

    GenericResponse authUser(AuthUserDTO authUserDTO);

    GenericResponse getKey(String key);
}
