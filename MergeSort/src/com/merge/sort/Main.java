package com.merge.sort;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        int[] num = new int[30];

        for(int i =0;i<num.length;i++)
            num[i] = random.nextInt(1000) - 500;

        MergeSort array = new MergeSort(num);

        array.mergeSort();

        array.showArray();
    }
}
