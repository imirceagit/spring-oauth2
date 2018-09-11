package com.mient.resourceserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/message")
    public String randomMessage() {
        return "Random message";
    }
}
