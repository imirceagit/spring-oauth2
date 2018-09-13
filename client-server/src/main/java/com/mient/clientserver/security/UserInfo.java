package com.mient.clientserver.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public class UserInfo {
    private String firstName;
    private String lastName;

    public static UserInfo create(Object userObject) {
        Map<String, String> userMap = (LinkedHashMap<String, String>) userObject;
        return new UserInfo(userMap.get("firstName"), userMap.get("lastName"));
    }
}
