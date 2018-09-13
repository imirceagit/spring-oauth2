package com.mient.authserver.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DealerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dealer_setting_id")
    private Long id;
    private String dealerId;
    private String dealerName;
    private String branchId;
    private String branchName;
}
