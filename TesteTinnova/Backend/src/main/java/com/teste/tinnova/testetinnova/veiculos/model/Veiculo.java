package com.teste.tinnova.testetinnova.veiculos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Veiculo extends DefaultClass {

    @NotBlank(message = "Veiculo não pode ser nulo")
    private String veiculo;
    @NotBlank(message = "Marca não pode ser nulo")
    private String marca;

    private Integer ano;
    @NotBlank(message = "Descricao não pode ser nulo")
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private Boolean vendido;

    public Veiculo() {

    }
}
