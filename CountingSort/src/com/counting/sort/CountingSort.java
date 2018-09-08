package com.counting.sort;

public class CountingSort {
    int [] nums;

    public CountingSort(int[] nums) {
        this.nums = nums;
    }

    public void sort (int max,int min){
        int [] countArray = new int[(max - min) + 1];

        for(int i=0;i<nums.length;i++){
            countArray[nums[i]-min]++;
        }
        int z=0;

        for(int i=min;i<=max;i++){
            while(countArray[i-min] > 0){
                this.nums[z] = i;
                z++;
                countArray[i-min]--;
            }
        }
    }
    public void showArray() {
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " , ");
    }
}
