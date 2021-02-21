package com.algorithm.framwork.combination;

import java.util.Stack;

/**
 * @AUTHOR: HYT
 * @DESCRIPTION the algorithm framework about permutation and combination
 * @EXAMPLE first:
 * @IN: [2, 3, 4, 6]
 * @OUT: (2, 6, 3, 4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 * (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
 *
 */
public class Combination {
    //排列组合
    public static Stack<Integer> stack = new Stack<>();
    int n = 0;

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        Combination combination = new Combination();
        combination.combin(nums, 4, 0, 0);
    }

    private void combin(int[] nums, int targ, int count, int cur) {
        if (targ == count) {
            System.out.println(stack);
            return;
        }
        //just the combination of sorted number
        //for (int i = cur; i < nums.length; i++) {

        //all the combination number
        for (int i = 0; i < nums.length; i++) {
            if (!stack.contains(nums[i])) {
                stack.add(nums[i]);
                combin(nums, targ, count + 1, i);
                stack.pop();
            }
        }
    }

}
