//给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。 
//
// 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。 
//
// 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。 
//
// 
//
// 示例 1： 
//
// 
//输入：[[1,1,0],[1,0,1],[0,0,0]]
//输出：[[1,0,0],[0,1,0],[1,1,1]]
//解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
//     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
//     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length = A[0].length <= 20 
// 0 <= A[i][j] <= 1 
// 
// Related Topics 数组 
// 👍 227 👎 0


package com.cute.leetcode.editor.cn;

//翻转图像

/**
 * @author tommywing
 * @date 2021-02-24 13:10:09
 * @description
 */
public class P832_FlippingAnImage {
    public static void main(String[] args) {
        //test code
        Solution solution = new P832_FlippingAnImage().new Solution();

        int[][] A = solution.flipAndInvertImage(new int[][]{{1, 1, 0}, {0, 0, 0}, {1, 0, 1}, {0, 1, 0}, {1, 1, 1}});
        System.out.println(A.length);
        int row = A.length, col = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
    }

    //question code
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            for (int i = 0; i < A.length; i++) {
                int l = 0, r = A[0].length - 1;
                while (l <= r) {
                    if (A[i][l] == A[i][r]) {
                        A[i][l] = A[i][r] = A[i][r] ^ 1;
                    }
                    l++;
                    r--;
                }
            }

            return A;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}