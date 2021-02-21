package com.algorithm.framwork.multiNumsPair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @AUTHOR: HYT
 * @DESCRIPTION find two pairs of number both have the same calculation result.
 * @EXAMPLE: a*b=d*c
 */
public class MultiNumsPair {
    public static void main(String[] args) {
        MultiNumsPair multiNumsPair = new MultiNumsPair();
        multiNumsPair.findPair(new int[]{3, 4, 7, 10, 20, 9, 8});
    }

    public int[][] findPair(int[] nums) {
        HashMap<Integer, PairNum> pairMap = new HashMap<Integer, PairNum>();
        List<int[]> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                int multi = nums[i] * nums[j];
                if (!pairMap.containsKey(multi)) {
                    pairMap.put(multi, new PairNum(i, j));
                } else {
                    PairNum pairNum = pairMap.get(multi);
//                    if (pairNum.first != i && pairNum.first != j &&
//                            pairNum.second != i && pairNum.second != j) {

                        int[] ints = new int[]{pairNum.first, pairNum.second, i, j};
                    if (pairNum.first != i && pairNum.first != j &&
                            pairNum.second != i && pairNum.second != j) {
                            System.out.println("(" + nums[pairNum.first] + "," + nums[pairNum.second] + "),(" + nums[i] + "," + nums[j] + ")");
                        }
                        lists.add(ints);
//                    }

                }
            }
        }
        int[][] pairRes = new int[lists.size()][4];
        for (int i = 0; i < lists.size(); i++) {
            pairRes[i] = lists.get(i);
            for (int res : pairRes[i]) {
//                System.out.print(res);
            }
//            System.out.println();
        }
        return pairRes;
    }

    class PairNum {
        Integer first;
        Integer second;

        public PairNum(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}

