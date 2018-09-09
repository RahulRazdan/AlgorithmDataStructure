package com.quickselect.encode;

public class Main {

    public static void main(String[] args) {
        int [] nums = {1,5,4,8,-2};
        System.out.print(new QuickSelect(nums).select(1));
    }
}
