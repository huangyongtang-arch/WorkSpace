package com.cute.leetcode.editor.util;

public class ReverseArray {

    public void reverse(int[] nums,int start,int end){
        while(start<end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
    public void reverseFullNums(int[] nums) {
        int j = nums.length - 1;
        for (int i = 0; i < nums.length / 2; i++) {
            if (nums.length % 2 == 0) {
                if (j >= nums.length / 2) {
                    swap(nums, i, j);
                    j--;
                }
            }
            if (nums.length % 2 != 0) {
                if (j > nums.length / 2) {
                    swap(nums, i, j);
                    j--;
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
