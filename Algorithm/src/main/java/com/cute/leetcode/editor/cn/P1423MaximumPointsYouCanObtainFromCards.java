package com.cute.leetcode.editor.cn;
//There are several cards arranged in a row, and each card has an associated num
//ber of points The points are given in the integer array cardPoints. 
//
// In one step, you can take one card from the beginning or from the end of the 
//row. You have to take exactly k cards. 
//
// Your score is the sum of the points of the cards you have taken. 
//
// Given the integer array cardPoints and the integer k, return the maximum scor
//e you can obtain. 
//
// 
// Example 1: 
//
// 
//Input: cardPoints = [1,2,3,4,5,6,1], k = 3
//Output: 12
//Explanation: After the first step, your score will always be 1. However, choos
//ing the rightmost card first will maximize your total score. The optimal strateg
//y is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 1
//2.
// 
//
// Example 2: 
//
// 
//Input: cardPoints = [2,2,2], k = 2
//Output: 4
//Explanation: Regardless of which two cards you take, your score will always be
// 4.
// 
//
// Example 3: 
//
// 
//Input: cardPoints = [9,7,7,9,7,7,9], k = 7
//Output: 55
//Explanation: You have to take all the cards. Your score is the sum of points o
//f all cards.
// 
//
// Example 4: 
//
// 
//Input: cardPoints = [1,1000,1], k = 1
//Output: 1
//Explanation: You cannot take the card in the middle. Your best score is 1. 
// 
//
// Example 5: 
//
// 
//Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
//Output: 202
// 
//
// 
// Constraints: 
//
// 
// 1 <= cardPoints.length <= 10^5 
// 1 <= cardPoints[i] <= 10^4 
// 1 <= k <= cardPoints.length 
// 
// Related Topics 数组 动态规划 Sliding Window 
// 👍 114 👎 0

import java.util.Arrays;

/**
 * @author tommywing
 * @description
 */
public class P1423MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        Solution solution = new P1423MaximumPointsYouCanObtainFromCards().new Solution();
        solution.maxScore(new int[]{1,79,80,1,1,1,200,1},3);
        solution.maxScore(new int[]{1,1000,1},1);
        solution.maxScore(new int[]{9,7,7,9,7,7,9},7);
        solution.maxScore(new int[]{2,2,2},2);
        solution.maxScore(new int[]{1,2,3,4,5,6,1},3);

        solution.maxScore(new int[]{100,40,17,9,73,75},3);
    }

    /*
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int cardLen = cardPoints.length;

            //the windowSize
            int windowSize = cardLen-k;

            // init the sliding window
            int sum = 0;
            for (int i = 0; i < windowSize; i++) {
                sum += cardPoints[i];
            }
            int minSum = sum;

            // begin slide the sliding window
            for (int i = windowSize; i < cardLen; i++) {
                sum += cardPoints[i] - cardPoints[i-windowSize];
                minSum = Math.min(sum,minSum);
            }

            return Arrays.stream(cardPoints).sum() - minSum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}