//给你一个数组 rectangles ，其中 rectangles[i] = [li, wi] 表示第 i 个矩形的长度为 li 、宽度为 wi 。 
//
// 如果存在 k 同时满足 k <= li 和 k <= wi ，就可以将第 i 个矩形切成边长为 k 的正方形。例如，矩形 [4,6] 可以切成边长最大为 
//4 的正方形。 
//
// 设 maxLen 为可以从矩形数组 rectangles 切分得到的 最大正方形 的边长。 
//
// 返回可以切出边长为 maxLen 的正方形的矩形 数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：rectangles = [[5,8],[3,9],[5,12],[16,5]]
//输出：3
//解释：能从每个矩形中切出的最大正方形边长分别是 [5,3,5,5] 。
//最大正方形的边长为 5 ，可以由 3 个矩形切分得到。
// 
//
// 示例 2： 
//
// 
//输入：rectangles = [[2,3],[3,7],[4,3],[3,7]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rectangles.length <= 1000 
// rectangles[i].length == 2 
// 1 <= li, wi <= 109 
// li != wi 
// 
// Related Topics 贪心算法 
// 👍 5 👎 0

package com.cute.leetcode.editor.cn;
//java:可以形成最大正方形的矩形数目
public class P1725NumberOfRectanglesThatCanFormTheLargestSquare{
    public static void main(String[] args){
        Solution solution = new P1725NumberOfRectanglesThatCanFormTheLargestSquare().new Solution();
        solution.countGoodRectangles(new int[][]{{2,3},{3,7},{4,3},{3,7}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int[] reg = new int[rectangles.length];

        int count = 0;
        int max = 0;
        for(int[] rec: rectangles){
            if(rec[0] < rec[1]){
                if(max<rec[0]){max = rec[0];}
                reg[count] = rec[0];
            }
            if(rec[0] > rec[1]){
                if(max<rec[1]){max = rec[1];}
                reg[count] = rec[1];
            }
            count++;
        }

        int num = 0;
        for(int i=0;i<reg.length;i++){
            if(reg[i] == max){
                num++;
            }
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}