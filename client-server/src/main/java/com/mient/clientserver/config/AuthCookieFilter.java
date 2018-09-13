package com.mient.clientserver.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mient.clientserver.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class AuthCookieFilter extends OncePerRequestFilter {

    private final SecurityUtils securityUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ObjectMapper om = new ObjectMapper();
        Cookie dealerDetails = new Cookie("DEALER_DETAILS",
                Base64.getEncoder().encodeToString(om.writeValueAsString(securityUtils.getUserContext()).getBytes()));
        response.addCookie(dealerDetails);
        filterChain.doFilter(request, response);
    }
}
