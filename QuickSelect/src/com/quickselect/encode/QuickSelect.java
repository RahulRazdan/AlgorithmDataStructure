package com.quickselect.encode;

import java.util.Random;

public class QuickSelect {

    int [] nums;

    public QuickSelect(int[] nums) {
        this.nums = nums;
    }

    public int select ( int k){
        return select(k-1,0,nums.length-1);
    }

    private int select(int k, int firstIndex, int lastIndex) {
        int pivot = partition(firstIndex,lastIndex);

        if(pivot > k){
            select(k,firstIndex,pivot-1);
        }else if(pivot < k){
            select(k,pivot+1,lastIndex);
        }

        return nums[k];
    }

    private int partition(int firstIndex, int lastIndex) {

        int pivot = new Random().nextInt(lastIndex-firstIndex+1) + firstIndex;

        swap(pivot,lastIndex);

        for(int i=firstIndex;i<lastIndex;i++) {
            if (nums[i] > nums[lastIndex]){
                swap(i, firstIndex);
                firstIndex++;
            }
        }

        swap(lastIndex,firstIndex);

        return firstIndex;
    }

    private void swap(int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
