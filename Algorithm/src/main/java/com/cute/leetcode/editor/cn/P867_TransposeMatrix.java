//给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。 
//
// 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[1,4,7],[2,5,8],[3,6,9]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6]]
//输出：[[1,4],[2,5],[3,6]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 1000 
// 1 <= m * n <= 105 
// -109 <= matrix[i][j] <= 109 
// 
// Related Topics 数组 
// 👍 173 👎 0


package com.cute.leetcode.editor.cn;

//转置矩阵

import java.util.Arrays;

/**
 * @date 2021-02-25 16:07:41
 * @author tommywing
 * @description
 */
public class P867_TransposeMatrix{
	 public static void main(String[] args) {
        //test code
	 	 Solution solution = new P867_TransposeMatrix().new Solution();
	 	 solution.transpose(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
         System.out.println();
	 	 solution.transpose(new int[][]{{1,2,3},{4,5,6}});
	 }
    //question code
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] reversed = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (i != j){
                    reversed[i][j] = matrix[j][i];
                }
                if (i == j){
                    reversed[i][j] = matrix[i][j];
                }
            }
        }
//        Arrays.stream(reversed).forEach(ints -> {
//            Arrays.stream(ints).forEach(System.out::print);
//            System.out.println();
//        });
        return reversed;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}