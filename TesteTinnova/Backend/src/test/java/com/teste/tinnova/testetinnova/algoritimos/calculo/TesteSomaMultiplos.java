package com.teste.tinnova.testetinnova.algoritimos.calculo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteSomaMultiplos {

    SomaMultiplos somaMultiplos;

    @BeforeEach
    void iniciaSomaMultiplos(){
        this.somaMultiplos = new SomaMultiplos();
    }

    @Test
    void testecalculaPassandoMuitosComparadores(){
        Integer resp = somaMultiplos.calculaPassandoMuitosComparadores(10, 3,5);
        Assertions.assertEquals(23, resp);
    }

    @Test
    void testecalcula(){
        Integer resp = somaMultiplos.calcula();
        Assertions.assertEquals(23, resp);
    }



}
