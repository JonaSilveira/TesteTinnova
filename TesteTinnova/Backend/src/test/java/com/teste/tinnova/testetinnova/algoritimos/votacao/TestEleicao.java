package com.teste.tinnova.testetinnova.algoritimos.votacao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEleicao {

    Votacao votacao;

    @BeforeEach
    public void iniciaVotacao(){
        this.votacao = new Votacao();
    }

    @Test
    public void testVotosValidosXTotalEleitores(){
        Float resultado = this.votacao.votosValidosXTotalEleitores();
        Assertions.assertEquals(80, resultado);
    }


    @Test
    public void testVotosBrancosXTotalEleitores(){
        Float resultado = this.votacao.votosBrancosXTotalEleitores();
        Assertions.assertEquals(15, resultado);
    }

    @Test
    public void testVotosNulosXTotalEleitores(){
        Float resultado = this.votacao.votosNulosXTotalEleitores();
        Assertions.assertEquals(5, resultado);
    }


}
