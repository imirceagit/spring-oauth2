package com.mient.clientserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

//    @Autowired
//    private OAuth2RestTemplate restTemplate;
//
//    @Value("${message.api:http://localhost:18080/message}")
//    String messageApi;

    @GetMapping("/index")
    public String home(Model model) {
//        String message = restTemplate.getForObject(messageApi, String.class);
//        return message;
        return "MULTA MUIE";

    }
}
