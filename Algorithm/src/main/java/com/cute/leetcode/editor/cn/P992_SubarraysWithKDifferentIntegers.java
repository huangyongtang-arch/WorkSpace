//给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。 
//
// （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。） 
//
// 返回 A 中好子数组的数目。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,2,1,2,3], K = 2
//输出：7
//解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
// 
//
// 示例 2： 
//
// 输入：A = [1,2,1,3,4], K = 3
//输出：3
//解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 1 <= A[i] <= A.length 
// 1 <= K <= A.length 
// 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 174 👎 0


package com.cute.leetcode.editor.cn;

//K 个不同整数的子数组

import java.util.ArrayList;
import java.util.List;

/**
 * @author tommywing
 * @date 2021-02-09 10:07:30
 * @description
 */
public class P992_SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        //test code
        Solution solution = new P992_SubarraysWithKDifferentIntegers().new Solution();
//	 	 solution.subarraysWithKDistinct();
    }

    //question code
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraysWithKDistinct(int[] A, int K) {

            return K;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}