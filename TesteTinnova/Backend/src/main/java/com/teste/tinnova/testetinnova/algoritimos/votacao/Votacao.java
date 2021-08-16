package com.teste.tinnova.testetinnova.algoritimos.votacao;


import lombok.Data;

@Data
public class Votacao {

    private final Float totalEleitores = 1000f;
    private final Float votosValidos = 800f;
    private final Float votosBrancos = 150f;
    private final Float votosNulos = 50f;

    public Votacao() {
    }
    public Float votosValidosXTotalEleitores() {
        return calculaPercent(votosValidos);
    }

    public Float votosBrancosXTotalEleitores() {
        return calculaPercent(votosBrancos);
    }

    public Float votosNulosXTotalEleitores() {
        return calculaPercent(votosNulos);
    }
    public Float calculaPercent(Float valor){
        return (valor/totalEleitores)*100;
    }

}
