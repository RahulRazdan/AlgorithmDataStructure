package com.merge.sort;

public class MergeSort {

    private int[] num;
    private int[] tempArray;

    public MergeSort(int[] num) {
        this.num = num;
        this.tempArray = new int[num.length];
    }

    public void mergeSort() {
        this.mergeSort(0, num.length - 1);
    }

    private void mergeSort(int low, int high) {

        if (low >= high) return;

        int middle = (low + high) / 2;

        this.mergeSort(low, middle);
        this.mergeSort(middle + 1, high);
        this.merge(low, middle, high);
    }

    private void merge(int low, int middle, int high) {

        for (int i = low; i <= high; i++)
            tempArray[i] = num[i];

        int i = low;
        int j = middle + 1;
        int k = low;

        while ((i <= middle) && (j <= high)) {
            if (tempArray[i] <= tempArray[j]) {
                num[k] = tempArray[i];
                i++;
            } else {
                num[k] = tempArray[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            num[k] = tempArray[i];
            i++;
            k++;
        }

        while (j <= high) {
            num[k] = tempArray[j];
            j++;
            k++;
        }

    }

    private void swap(int pivotIndex, int high) {
        int temp = num[pivotIndex];
        num[pivotIndex] = num[high];
        num[high] = temp;
    }

    public void showArray() {
        for (int i = 0; i < num.length; i++)
            System.out.print(num[i] + " , ");
    }
}
