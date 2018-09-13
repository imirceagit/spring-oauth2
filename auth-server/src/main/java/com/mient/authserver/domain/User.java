package com.mient.authserver.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractBaseEntity{

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    private String firstName;
    private String lastName;

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private DealerDetails dealerDetails;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_authorities")
    private Set<String> authorities;
}
