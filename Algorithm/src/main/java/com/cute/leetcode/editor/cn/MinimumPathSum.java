//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 512 👎 0

package com.cute.leetcode.editor.cn;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
        int res = solution.minPathSum(new int[][]{
                {1, 3, 1}
                , {1, 5, 1}
                , {4, 2, 1}
        });
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int colL = grid.length - 1;
            int rowL = grid[0].length - 1;
            int memo[][] = new int[colL + 1][rowL + 1];

            memo[colL][rowL] = grid[colL][rowL];
            for (int i = colL - 1; i >= 0; i--) {
                memo[i][rowL] = memo[i + 1][rowL] + grid[i][rowL];
            }
            for (int j = rowL - 1; j >= 0; j--) {
                memo[colL][j] = memo[colL][j + 1] + grid[colL][j];
            }
            for (int i = colL - 1; i >= 0; i--) {
                for (int j = rowL - 1; j >= 0; j--) {
                    memo[i][j] = grid[i][j] + Math.min(memo[i][j + 1], memo[i + 1][j]);
                }
            }
            return memo[0][0];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}