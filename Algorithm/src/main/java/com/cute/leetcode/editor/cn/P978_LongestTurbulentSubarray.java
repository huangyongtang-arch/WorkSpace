//当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组： 
//
// 
// 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]； 
// 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。 
// 
//
// 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。 
//
// 返回 A 的最大湍流子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：[9,4,2,10,7,8,8,1,9]
//输出：5
//解释：(A[1] > A[2] < A[3] > A[4] < A[5])
// 
//
// 示例 2： 
//
// 输入：[4,8,12,16]
//输出：2
// 
//
// 示例 3： 
//
// 输入：[100]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 40000 
// 0 <= A[i] <= 10^9 
// 
// Related Topics 数组 动态规划 Sliding Window 
// 👍 99 👎 0


package com.cute.leetcode.editor.cn;

//最长湍流子数组

/**
 * @author tommywing
 * @date 2021-02-08 10:41:41
 * @description
 */
public class P978_LongestTurbulentSubarray {
    public static void main(String[] args) {
        //test code
        Solution solution = new P978_LongestTurbulentSubarray().new Solution();
        solution.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9});
        solution.maxTurbulenceSize(new int[]{9, 9});
    }

    //question code
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            //arr长度
            int arrLen = arr.length;
            if (arrLen < 2) {
                return arrLen;
            }

            int[] up = new int[arrLen];
            int[] down = new int[arrLen];
            int ans = 0;

            //双指针
            int i = 0, j = 1;
            while (j < arrLen) {
                if (arr[i] > arr[j]) {
                    down[j] = up[j - 1] + 1;
                } else if (arr[i] < arr[j]) {
                    up[j] = down[j - 1] + 1;
                }
                ans = Math.max(ans, Math.max(up[j], down[j]));
                i++;
                j++;
            }
            System.out.println(ans);
            return ans + 1;
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)