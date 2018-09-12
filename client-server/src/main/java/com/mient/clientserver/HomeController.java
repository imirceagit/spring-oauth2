package com.mient.clientserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class HomeController {

    private final String resource = "http://localhost:18080/message";

    @Autowired
    private OAuth2RestTemplate restTemplate;

    @Autowired
    private TokenStore tokenStore;

    @GetMapping("/public")
    public String publicMethod(Model model) {
        String message = restTemplate.getForObject(resource,  String.class);
        model.addAttribute("message", message);
        return "message";
    }

    @GetMapping("/private")
    public String privateMethod(Model model, OAuth2Authentication authentication, HttpServletResponse response) {
        response.addCookie(new Cookie("LOCATION-SRV", "CLI"));
        model.addAttribute("person", authentication.getPrincipal());
        return "personinfo";
    }

    public Map<String, Object> getExtraInfo(OAuth2Authentication auth) {
        OAuth2AuthenticationDetails details
                = (OAuth2AuthenticationDetails) auth.getDetails();
        OAuth2AccessToken accessToken = tokenStore
                .readAccessToken(details.getTokenValue());
        return accessToken.getAdditionalInformation();
    }
}
