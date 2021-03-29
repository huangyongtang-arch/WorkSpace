//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 二分查找 动态规划 
// 👍 1387 👎 0


package com.cute.leetcode.editor.cn;

//最长递增子序列

import java.util.Arrays;

/**
 * @author tommywing
 * @date 2021-03-04 12:01:15
 * @description
 */
public class P300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        //test code
        Solution solution = new P300_LongestIncreasingSubsequence().new Solution();
    }

    //question code
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 单向遍历动态规划
         *
         * @param nums
         * @return
         */
        public int lengthOfLIS_only_dp(int[] nums) {
            int nlen = nums.length;

            int[] dp = new int[nlen];
            Arrays.fill(dp, 1);

            for (int i = 1; i < nlen; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int res = 0, dplen = dp.length;
            for (int i = 0; i < dplen; i++) {
                res = Math.max(res, dp[i]);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}