package com.tn.basic.authentication.orm;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity(name = "user_login")
public class UserLogin {

    @Id
    private Long id;

    @Column
    private String username;

    @Column(name="password")
    private String password;
}
