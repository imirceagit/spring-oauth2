package com.mient.authserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/public")
    public String publicMethod() {
        return "§ --- PUBLIC --- §";
    }

    @GetMapping("/private")
    public String privateMethod() {
        return "§§§§ PRIVATE §§§§";
    }

    @GetMapping("/user")
    public Principal userinfo(Principal principal) {
        return principal;
    }
}
