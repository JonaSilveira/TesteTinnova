package com.teste.tinnova.testetinnova.algoritimos.calculo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFatorial {

    Fatorial fatorial;

    @BeforeEach
    void iniciaCalculo(){
        this.fatorial = new Fatorial();
    }

    @Test
    void testFatorial(){
        Integer result = this.fatorial.calculeFatorial(this.fatorial.getFatorial());
        Assertions.assertEquals(120, result);
    }

    @Test
    void testFatorialRecursivo(){
        Integer result = this.fatorial.calculeFatorialRecursivo(this.fatorial.getFatorial());
        Assertions.assertEquals(120, result);
    }

}
