package com.teste.tinnova.testetinnova.algoritimos.sort;

import com.teste.tinnova.testetinnova.algoritimos.sort.BubbleSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestBubbleSort {

    BubbleSort bubbleSort;

    @BeforeEach
    void iniciaBubbleSort(){
        bubbleSort = new BubbleSort();
    }

    @Test
    void testBubbleSort(){
        Integer[] vetorOrdenado = this.bubbleSort.implementsBubbleSort();
        Assertions.assertTrue(Arrays.equals(new Integer[]{0,1,2,3,4,5,6,7}, vetorOrdenado));
    }

}
