//给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如
//同俄罗斯套娃一样。 
//
// 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 说明: 
//不允许旋转信封。 
//
// 示例: 
//
// 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3 
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
// 
// Related Topics 二分查找 动态规划 
// 👍 320 👎 0


package com.cute.leetcode.editor.cn;

//俄罗斯套娃信封问题

/**
 * @date 2021-03-04 09:22:45
 * @author tommywing
 * @description
 */
public class P354_RussianDollEnvelopes{
	 public static void main(String[] args) {
        //test code
	 	 Solution solution = new P354_RussianDollEnvelopes().new Solution();
	 }
    //question code
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int rowlen = envelopes.length;
        int collen = envelopes[0].length;


        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}