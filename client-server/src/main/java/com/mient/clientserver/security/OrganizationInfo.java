package com.mient.clientserver.security;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class OrganizationInfo {
    private String dealerId;
    private String dealerName;
    private String branchId;
    private String branchName;

    public static OrganizationInfo create(Object object) {
        Map<String, String> map = (LinkedHashMap<String, String>) object;
        return new OrganizationInfo(map.get("dealerId"), map.get("dealerName"), map.get("branchId"), map.get("branchName"));
    }
}
