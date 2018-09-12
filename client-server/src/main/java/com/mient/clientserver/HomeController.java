package com.mient.clientserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    private final String resource = "http://localhost:18080/message";

    @Autowired
    private OAuth2RestTemplate restTemplate;

    @GetMapping("/public")
    public String publicMethod(Model model) {
        model.addAttribute("person", "Mircea");
        return "personinfo";
    }

    @GetMapping("/private")
    @ResponseBody
    public String privateMethod(OAuth2Authentication authentication) {
        SecurityContextHolder.getContext();
        return "§§§§ PRIVATE MESSAGE §§§§";
    }
}
