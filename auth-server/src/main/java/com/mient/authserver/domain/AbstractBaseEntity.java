package com.mient.authserver.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@MappedSuperclass
@EqualsAndHashCode(of = "id")
public abstract class AbstractBaseEntity {
    @Id
    private String id;

    protected AbstractBaseEntity() {
        this.id = UUID.randomUUID().toString();
    }
}
