//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 624 👎 0

package com.cute.leetcode.editor.cn;
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        System.out.println(solution.numTrees(3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//        对于这个例子，不同二叉搜索树的个数为 F(3, 7)F(3,7)。
//        我们将 [1,2][1,2] 构建不同左子树的数量表示为 G(2)G(2), 从
//        [4, 5, 6, 7][4,5,6,7] 构建不同右子树的数量表示为 G(4)G(4)，注意到 G(n)G(n) 和序列的内容无关，
//        只和序列的长度有关。于是，F(3,7) = G(2)* G(4)F(3,7)=G(2)*G(4)
    public int numTrees(int n) {
        int[] nums=new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i=2;i<n+1;i++){
            for(int j=1;j<i+1;j++){
                nums[i] += nums[j-1]*nums[i-j];
            }
        }
        return nums[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}