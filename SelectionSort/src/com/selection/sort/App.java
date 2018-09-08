package com.selection.sort;

public class App {

    public static void main(String args[]){
        int[] nums = {1,-4,56,4,234,2,0};

        showArray(nums);

        System.out.println();

        selectionSort(nums);

        showArray(nums);
    }

    public static void selectionSort(int [] nums){
        for(int i=0;i<nums.length-1;i++){
            int index = i;
            for(int j=i+1;j<nums.length;j++){
                if (nums[j] < nums[index])
                    index = j;
            }

            if(i != index)
                swap(nums,i,index);
        }
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void showArray(int[] nums){
        for(int i =0;i<nums.length;i++)
            System.out.print(nums[i] + " , ");
    }
}
