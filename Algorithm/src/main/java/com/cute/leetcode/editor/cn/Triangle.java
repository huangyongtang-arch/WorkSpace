//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 446 👎 0

package com.cute.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();

        List<List<Integer>> list = new ArrayList();
        List<Integer> l1 = Arrays.asList(2);
        List<Integer> l2 = Arrays.asList(3, 4);
        List<Integer> l3 = Arrays.asList(6, 5, 7);
        List<Integer> l4 = Arrays.asList(4, 1, 8, 3);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        solution.minimumTotal(list);
//        System.out.println(list.size());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int len = triangle.size();
            int memo[][] = new int[len][len];
            if (len==0) return 0;
            memo[0][0] = triangle.get(0).get(0);
            for(int i=1;i<len;i++){
                memo[i][0] = memo[i-1][0]+triangle.get(i).get(0);
                for(int j=1;j<i;j++){
                    memo[i][j] = Math.min(memo[i-1][j],memo[i-1][j-1]) + triangle.get(i).get(j);
                }
                memo[i][i] = memo[i-1][i-1]+triangle.get(i).get(i);
            }
            int res = memo[len-1][0];
            for (int i=1;i<len;i++){
                res = Math.min(memo[len-1][i],res);
            }
            System.out.println(res);
            return res;
        }

        /**
         * @param triangle
         * @return
         * @answer 动态规划
         * @time O(n ^ 2)
         * @space O(n ^ 2)
         */
        public int minimumTotal1(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] f = new int[n][n];
            f[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < n; ++i) {
                f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
                for (int j = 1; j < i; ++j) {
                    f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
                }
                f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
            }
            int minTotal = f[n - 1][0];
            for (int i = 1; i < n; ++i) {
                minTotal = Math.min(minTotal, f[n - 1][i]);
            }
            return minTotal;
        }

        /**
         * @answer 动态规划+空间优化
         * @space O(n)
         * @空间存储状态 2n
         * @param triangle
         * @return
         */
        public int minimumTotal2(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] f = new int[2][n];
            f[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < n; ++i) {
                int curr = i % 2;
                int prev = 1 - curr;
                f[curr][0] = f[prev][0] + triangle.get(i).get(0);
                for (int j = 1; j < i; ++j) {
                    f[curr][j] = Math.min(f[prev][j - 1], f[prev][j]) + triangle.get(i).get(j);
                }
                f[curr][i] = f[prev][i - 1] + triangle.get(i).get(i);
            }
            int minTotal = f[(n - 1) % 2][0];
            for (int i = 1; i < n; ++i) {
                minTotal = Math.min(minTotal, f[(n - 1) % 2][i]);
            }
            return minTotal;
        }

        /**
         * @answer 空间再优化
         * @空间存储状态 n
         * @param triangle
         * @return
         */
        public int minimumTotal3(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] f = new int[n];
            f[0] = triangle.get(0).get(0);
            for (int i = 1; i < n; ++i) {
//                System.out.println("i:"+i);
                f[i] = f[i - 1] + triangle.get(i).get(i);
                for (int j = i - 1; j > 0; --j) {
//                    System.out.println("j:"+j);
                    f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
                }
                f[0] += triangle.get(i).get(0);
            }
            int minTotal = f[0];
            for (int i = 1; i < n; ++i) {
                minTotal = Math.min(minTotal, f[i]);
            }
            return minTotal;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}