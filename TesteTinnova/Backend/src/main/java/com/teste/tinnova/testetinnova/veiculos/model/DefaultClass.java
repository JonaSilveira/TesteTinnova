package com.teste.tinnova.testetinnova.veiculos.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@Data
public class DefaultClass {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    private LocalDate created;
    private LocalDate updated;

    public DefaultClass() {
        this.id = UUID.randomUUID().toString();
        this.created = LocalDate.now();
        this.updated = LocalDate.now();
    }
}

