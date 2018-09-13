package com.mient.clientserver.controller;

import com.mient.clientserver.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final String resource = "http://localhost:18080/message";

    private final OAuth2RestTemplate restTemplate;

    private final SecurityUtils securityUtils;

    @GetMapping("/public")
    public String publicMethod(Model model) {
        String message = restTemplate.getForObject(resource,  String.class);
        model.addAttribute("message", message);
        return "message";
    }

    @GetMapping("/private")
    public String privateMethod(Model model) {
        model.addAttribute("person", securityUtils.getUsername());
        Map<String, Object> extras = securityUtils.getExtraInfo();
        return "personinfo";
    }
}
