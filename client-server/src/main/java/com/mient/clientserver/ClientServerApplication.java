package com.mient.clientserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.web.client.RestTemplate;

@EnableOAuth2Sso
@SpringBootApplication
public class ClientServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServerApplication.class, args);
	}
//
//	@Bean
//	public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext oauth2ClientContext,
//												 OAuth2ProtectedResourceDetails details) {
//		return new OAuth2RestTemplate(details, oauth2ClientContext);
//	}

	@Bean
	public SimpleFilter simpleFilter() {
		return new SimpleFilter();
	}
}
