//给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。 
//
// 不占用额外内存空间能否做到？ 
//
// 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 101 👎 0
//输入:
//        [[1,2,3],[4,5,6],[7,8,9]]
//        输出
//        [[7,2,1],[6,5,4],[9,8,3]]
//        预期结果
//        [[7,4,1],[8,5,2],[9,6,3]]

package com.cute.leetcode.editor.cn;

import java.util.Arrays;

public class RotateMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new RotateMatrixLcci().new Solution();

        int[][] matrix = solution.rotate(new int[][] {  {1,2,3,4},
                                                        {5,6,7,8},
                                                        {9,10,11,12},
                                                     {13,14,15,16} });
        for (int[] i:matrix){
            for (int j:i){
                System.out.print(j+",");
            }
            System.out.println();
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] rotate(int[][] matrix) {
        int n=matrix.length;
        //x轴翻转
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int tmp=matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j]=tmp;
            }
        }

        //对角线翻转
        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }

        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}