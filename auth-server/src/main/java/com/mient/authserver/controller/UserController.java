package com.mient.authserver.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/private")
    public String privateMethod() {
        return "PRIVATE";
    }

    @GetMapping("/user")
    public Authentication userinfo(OAuth2Authentication authentication) {
        return authentication;
    }
}
