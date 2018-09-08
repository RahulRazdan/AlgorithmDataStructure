package com.insertion.sort;

public class Main {

    public static void main(String[] args) {
	    int num[]= {-4,0,45,1,-5,34,2,90,3,-2};

	    showArray(num);

	    System.out.println();

	    quickSort(num,0,num.length-1);

	    showArray(num);
    }

    private static void quickSort(int[] num,int low,int high) {

        if(low>=high) return;

        int pivot = partition(num,low,high);
        quickSort(num,low,pivot-1);
        quickSort(num,pivot+1,high);
    }

    private static int partition(int[] num, int low, int high) {

        int pivotIndex = (low+high)/2;
        swap(num,pivotIndex,high);
        int i =low;
        for(int j=low;j<high;j++) {
            if (num[j] <= num[high]) {
                swap(num, i, j);
                i++;
            }
        }
        swap(num,i,high);

        return i;
    }

    private static void swap(int[] num, int pivotIndex, int high) {
        int temp = num[pivotIndex];
        num[pivotIndex] = num[high];
        num[high] = temp;
    }

    private static void showArray(int[] num) {
        for(int i=0;i<num.length;i++)
            System.out.print(num[i] + " , ");
    }
}
