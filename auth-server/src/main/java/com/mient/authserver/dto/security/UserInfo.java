package com.mient.authserver.dto.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfo {
    private String firstName;
    private String lastName;

    public static UserInfo create(String firstName, String lastName) {
        return new UserInfo(firstName, lastName);
    }
}
