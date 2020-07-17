//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组 
// 👍 10 👎 0

package com.cute.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 */
public class ZeroMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci().new Solution();
        int matrix[][] = new int[][]{
                {1,2,3,4},
                {1,2,0,3},
                {1,0,3,4},
                {1,1,1,1}};
        solution.setZeroes(matrix);
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        List<Integer> row=new ArrayList<>();
        List<Integer> col=new ArrayList<>();

        for(int i=0;i<rowLen;i++){
            for (int j=0;j<colLen;j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int j:col){
            for(int i=0;i<rowLen;i++){
                matrix[i][j]=0;
            }
        }
        for (int i:row){
            for (int j=0;j<colLen;j++){
                matrix[i][j]=0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}