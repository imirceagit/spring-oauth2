package com.mient.authserver.config;

import com.mient.authserver.dto.security.OrganizationInfo;
import com.mient.authserver.dto.security.UserInfo;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
        LocalUserPrincipal principal = (LocalUserPrincipal) authentication.getUserAuthentication().getPrincipal();
        additionalInfo.put("organizationInfo", OrganizationInfo.create(principal.getUser().getDealerDetails()));
        additionalInfo.put("userInfo", UserInfo.create(principal.getUser().getFirstName(), principal.getUser().getLastName()));
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }

}