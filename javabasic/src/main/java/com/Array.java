package com;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[][] arrays={
                {1,2,3}
        ,{1,1,1}
        ,{1,1,1}
        ,{1,1,1}};

        int n=arrays.length;
        int m=arrays[0].length;

        int memo[][]=new int[n+1][m+1];
        for (int i=0;i<=n;i++){
            Arrays.fill(memo[i],-1);
        }

        for (int i=0;i<=n;i++) {
            Arrays.stream(memo[i]).forEach(System.out::print);
            System.out.println();
        }
    }
}
