package com.counting.sort;

public class Main {

    public static void main(String[] args) {

        int[] num = {1,6,8,2,6,89,10,4,2,5};

        CountingSort array = new CountingSort(num);
        array.sort(89,1);
        array.showArray();
    }
}
