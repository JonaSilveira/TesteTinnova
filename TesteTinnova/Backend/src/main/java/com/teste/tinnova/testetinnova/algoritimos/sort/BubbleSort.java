package com.teste.tinnova.testetinnova.algoritimos.sort;

import lombok.Data;

import java.util.Arrays;
import java.util.stream.Stream;

@Data
public class BubbleSort {

    private Integer[] vetorOriginal;
    private Integer[] vetorOrdenado;

    public BubbleSort() {
        vetorOriginal = new Integer[]{5, 3, 2, 4, 7, 1, 0, 6};
    }

    public Integer[] implementsBubbleSort(){
        Integer temp;
        for(int i = 0; i<this.vetorOriginal.length-1; i++){
            for(int j = i+1; j<this.vetorOriginal.length; j++) {
                if (this.vetorOriginal[i] > vetorOriginal[j]) {
                    temp = this.vetorOriginal[i];
                    this.vetorOriginal[i] = this.vetorOriginal[j];
                    this.vetorOriginal[j] = temp;
                }
            }
        }
        Arrays.stream(this.vetorOriginal).forEach(val -> System.out.print(val));

        return this.vetorOriginal;
    }

}
