package com.mient.clientserver.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SecurityUtilsImpl implements SecurityUtils{

    private final TokenStore tokenStore;

    @Override
    public String getUsername() {
        return String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    @Override
    public Map<String, Object> getExtraInfo() {
        OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(details.getTokenValue());
        return accessToken.getAdditionalInformation();
    }

    @Override
    public UserContext getUserContext() {
        Map<String, Object> extras = getExtraInfo();
        UserContext userContext = new UserContext();
        userContext.setUserInfo(UserInfo.create(extras.get("userInfo")));
        userContext.setOrganizationInfo(OrganizationInfo.create(extras.get("organizationInfo")));
        return userContext;
    }
}
