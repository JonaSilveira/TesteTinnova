package com.teste.tinnova.testetinnova.algoritimos.calculo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SomaMultiplos {

    public Integer calculaPassandoMuitosComparadores(Integer valorInicial, Integer... values){
        List<Integer> numeros = new ArrayList<>();

        Arrays.stream(values).forEach(numero->{
            for(int i =1; i<valorInicial; i++){
                if(i%numero==0 && !numeros.contains(i))
                    numeros.add(i);
            }
        });

        return numeros.stream().mapToInt(i->i).sum();
    }

    public Integer calcula(){
        Integer numeros = 0;

        for(int i =1; i<10; i++){
            if(i%3==0 || i%5==0)
                numeros+=i;
        }
        return numeros;
    }

}
