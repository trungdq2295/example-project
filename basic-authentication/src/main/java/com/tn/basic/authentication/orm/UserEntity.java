package com.tn.basic.authentication.orm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserEntity {
    private String username;
    private String password;
}
