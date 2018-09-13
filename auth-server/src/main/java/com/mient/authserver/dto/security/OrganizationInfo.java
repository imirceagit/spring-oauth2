package com.mient.authserver.dto.security;

import com.mient.authserver.domain.DealerDetails;
import lombok.Data;

@Data
public class OrganizationInfo {
    private String dealerId;
    private String dealerName;
    private String branchId;
    private String branchName;

    public static OrganizationInfo create(DealerDetails dealerDetails) {
        OrganizationInfo organizationInfo = new OrganizationInfo();
        organizationInfo.setDealerId(dealerDetails.getDealerId());
        organizationInfo.setDealerName(dealerDetails.getDealerName());
        organizationInfo.setBranchId(dealerDetails.getBranchId());
        organizationInfo.setBranchName(dealerDetails.getBranchName());
        return organizationInfo;
    }
}
