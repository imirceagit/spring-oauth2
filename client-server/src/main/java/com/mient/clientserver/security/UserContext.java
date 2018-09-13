package com.mient.clientserver.security;

import lombok.Data;

@Data
public class UserContext {
    private UserInfo userInfo;
    private OrganizationInfo organizationInfo;
}
