package com.teste.tinnova.testetinnova.algoritimos.calculo;

import lombok.Data;

@Data
public class Fatorial {

    public Integer fatorial = 5;//default value
    public Integer respFatorial = 1;
    public Fatorial(Integer fatorial) {
        this.fatorial = fatorial;
    }

    public Fatorial() {
    }

    public Integer calculeFatorial(Integer fatorial){
        Integer resp = 1;
        while (fatorial>0){
            resp *= fatorial--;
        }
        return resp;
    }

    public Integer calculeFatorialRecursivo(Integer fatorial){
        if(fatorial==0)
            return 1;
        return fatorial * calculeFatorialRecursivo(fatorial-1);
    }


}
