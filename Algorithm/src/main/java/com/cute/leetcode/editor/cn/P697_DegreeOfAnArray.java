//给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1, 2, 2, 3, 1]
//输出：2
//解释：
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2,3,1,4,2]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// nums.length 在1到 50,000 区间范围内。 
// nums[i] 是一个在 0 到 49,999 范围内的整数。 
// 
// Related Topics 数组 
// 👍 239 👎 0


package com.cute.leetcode.editor.cn;

//数组的度

import java.util.Arrays;

/**
 * @author tommywing
 * @date 2021-02-20 10:38:34
 * @description
 */
public class P697_DegreeOfAnArray {
    public static void main(String[] args) {
        //test code
        Solution solution = new P697_DegreeOfAnArray().new Solution();
    }

    //question code
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findShortestSubArray(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }
            if (len == 1) {
                return 1;
            }

            int[] freq = new int[50000];
            int ans = Integer.MAX_VALUE;
            int maxFreq = 0;

            for (int i = 0; i < len; i++) {
                freq[nums[i]]++;
                maxFreq = Math.max(maxFreq, freq[nums[i]]);
            }
            if (maxFreq == 1){return 1;}

            Arrays.fill(freq, 0);
            for (int i = 0; i < len; i++) {
                freq[nums[i]]++;
                if (freq[nums[i]] == maxFreq) {
                    //double pointer
                    int l = 0, r = 0;
                    while (l < len) {
                        if (nums[l] == nums[i]) {
                            break;
                        }
                        l++;
                    }
                    for (int j = l + 1; j < len; j++) {
                        if (nums[j] == nums[l]) {
                            r = j;
                        }
                    }
                    ans = Math.min(ans, r - l + 1);
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}