package com.mient.authserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Base64;

@RestController
public class UserController {

    @GetMapping("/private")
    public String privateMethod() {
        return "PRIVATE";
    }

    @GetMapping("/user")
    public Principal userinfo(Principal principal, OAuth2Authentication authentication, HttpServletResponse response) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        response.addCookie(new Cookie("LOCATION-SRV", "UAA"));
        response.addCookie(new Cookie("token", details.getTokenValue()));
        response.addCookie(new Cookie("user",
                Base64.getEncoder().encodeToString(om.writeValueAsString(new UserDetails(authentication.getName(), "Mircea", "Ionita")).getBytes())));
        return principal;
    }

    private class UserDetails {
        private String username;
        private String firstName;
        private String lastName;

        public UserDetails(String username, String firstName, String lastName) {
            this.username = username;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getUsername() {
            return username;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }
}
