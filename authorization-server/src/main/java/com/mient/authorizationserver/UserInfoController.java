package com.mient.authorizationserver;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableResourceServer
public class UserInfoController {

    @GetMapping("/userinfo")
    public Object userinfo(Authentication authentication) {
        return authentication;
    }
}
