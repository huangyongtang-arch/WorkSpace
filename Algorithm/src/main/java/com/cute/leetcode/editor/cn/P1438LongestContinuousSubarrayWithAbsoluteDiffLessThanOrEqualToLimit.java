package com.cute.leetcode.editor.cn;
//Given an array of integers nums and an integer limit, return the size of the l
//ongest non-empty subarray such that the absolute difference between any two elem
//ents of this subarray is less than or equal to limit. 
//
// 
// Example 1: 
//
// 
//Input: nums = [8,2,4,7], limit = 4
//Output: 2 
//Explanation: All subarrays are: 
//[8] with maximum absolute diff |8-8| = 0 <= 4.
//[8,2] with maximum absolute diff |8-2| = 6 > 4. 
//[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
//[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
//[2] with maximum absolute diff |2-2| = 0 <= 4.
//[2,4] with maximum absolute diff |2-4| = 2 <= 4.
//[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
//[4] with maximum absolute diff |4-4| = 0 <= 4.
//[4,7] with maximum absolute diff |4-7| = 3 <= 4.
//[7] with maximum absolute diff |7-7| = 0 <= 4. 
//Therefore, the size of the longest subarray is 2.
// 
//
// Example 2: 
//
// 
//Input: nums = [10,1,2,4,7,2], limit = 5
//Output: 4 
//Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute 
//diff is |2-7| = 5 <= 5.
// 
//
// Example 3: 
//
// 
//Input: nums = [4,2,2,2,4,4,2,2], limit = 0
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^9 
// 0 <= limit <= 10^9 
// 
// Related Topics 数组 Sliding Window 
// 👍 148 👎 0

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author tommywing
 * @description
 */
public class P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static void main(String[] args) {
        Solution solution = new P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().new Solution();
        /*test case*/
        solution.longestSubarray(new int[]{8, 2, 4, 7}, 4);

        solution.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5);

        solution.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0);
    }

    /*
     * question code
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            int len = nums.length;
            int l = 0, r = 0, mx = 0;
            Deque<Integer> maxQ = new LinkedList<>();
            Deque<Integer> minQ = new LinkedList<>();

            while (r < len) {
                while (!maxQ.isEmpty() && maxQ.peekLast() < nums[r]) {
                    maxQ.pollLast();
                }
                while (!minQ.isEmpty() && minQ.peekLast() > nums[r]) {
                    minQ.pollLast();
                }
                maxQ.offerLast(nums[r]);
                minQ.offerLast(nums[r]);
                while (!maxQ.isEmpty() && !minQ.isEmpty() && maxQ.peekFirst() - minQ.peekFirst() > limit) {
                    if (nums[l] == maxQ.peekFirst()) {
                        maxQ.pollFirst();
                    }
                    if (nums[l] == minQ.peekFirst()) {
                        minQ.pollFirst();
                    }
                    l++;
                }
                mx = Math.max(mx, r - l + 1);
                r++;
            }

            return mx;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}