package com.hibernate.Hibernate.one.to.one.mapping.Dto;

import lombok.Data;

@Data
public class LoginDto {

    private String usernameOrEmail;
    private String password;
}
