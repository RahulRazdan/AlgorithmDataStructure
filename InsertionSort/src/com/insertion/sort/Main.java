package com.insertion.sort;

public class Main {

    public static void main(String[] args) {

        int num[] = {-4,21,0,54,-5,7,2,1};

        showArray(num);

        System.out.println();

        insertionSort(num);

        showArray(num);
    }

    private static void insertionSort(int[] num) {

        for(int i=1;i<num.length;i++){
            int j = i;
            for(;j>0;--j){
                if(num[j-1] > num[j])
                    swap(num,j,j-1);
            }
        }
    }

    private static void swap(int[] num, int i, int index) {
        int temp = num[i];
        num[i] = num[index];
        num[index] = temp;
    }

    private static void showArray(int[] num) {
        for(int i=0;i<num.length;i++)
            System.out.print(num[i] + " , ");
    }
}
