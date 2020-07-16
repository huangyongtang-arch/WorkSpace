package com;

public class forEache {
    public static void main(String[] args) {
        int [][] nums=new int[][]{{1, 3}, {0, 2}, {1, 3},{0, 2}};
        int node = 0;
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i][0]);
        }
        System.out.println();
        for (int i:nums[node]
             ) {
            System.out.println(i);
        }
    }
}
