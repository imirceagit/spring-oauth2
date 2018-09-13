package com.mient.clientserver.security;

import java.util.Map;

public interface SecurityUtils {
    String getUsername();
    Map<String, Object> getExtraInfo();
    UserContext getUserContext();
}
