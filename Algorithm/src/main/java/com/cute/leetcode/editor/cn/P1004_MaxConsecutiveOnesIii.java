//给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。 
//
// 返回仅包含 1 的最长（连续）子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释： 
//[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 0 <= K <= A.length 
// A[i] 为 0 或 1 
// 
// Related Topics 双指针 Sliding Window 
// 👍 224 👎 0


package com.cute.leetcode.editor.cn;

//最大连续1的个数 III

/**
 * @author tommywing
 * @date 2021-02-19 22:11:20
 * @description
 */
public class P1004_MaxConsecutiveOnesIii {
    public static void main(String[] args) {
        //test code
        Solution solution = new P1004_MaxConsecutiveOnesIii().new Solution();
    }

    //question code
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] A, int K) {
            int len = A.length;
            int l = 0, r = 0;
            int res = 0;
            int zeros = 0;

            while (r < len) {
                if (A[r] == 0) {
                    zeros++;
                }
                while (zeros > K) {
                    if (A[l++] == 0) {
                        zeros--;
                    }
                }
                res = Math.max(res, r - l + 1);
                r++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}