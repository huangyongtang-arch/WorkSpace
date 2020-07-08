//你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方
//法，生成跳水板所有可能的长度。 
// 返回的长度需要从小到大排列。 
// 示例： 
// 输入：
//shorter = 1
//longer = 2
//k = 3
//输出： {3,4,5,6}
// 
// 提示： 
// 
// 0 < shorter <= longer 
// 0 <= k <= 100000 
// 
// Related Topics 递归 记忆化 
// 👍 33 👎 0

package com.cute.leetcode.editor.cn;

public class DivingBoardLcci {
    public static void main(String[] args) {
        Solution solution = new DivingBoardLcci().new Solution();
        forPrint(solution.divingBoard(1, 2, 3));
        forPrint(solution.divingBoard(2, 2, 3));
        forPrint(solution.divingBoard(1, 2, 1));
    }

    public static void forPrint(int[] res) {
        for (int i : res) {
            System.out.print(i == res[res.length - 1] ? i : (i + ","));
        }
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 根据公式 (k-i) * short + i * long
         *
         * @param shorter
         * @param longer
         * @param k
         * @return
         */
        public int[] divingBoard(int shorter, int longer, int k) {
            if (k == 0) {
                return new int[0];
            }
            if (shorter == longer) {
                int[] res = new int[1];
                res[0] = shorter * k;
                return res;
            }
            int[] res = new int[k + 1];
            for (int i = 0; i < k + 1; i++) {
                res[i] = ((k - i) * shorter) + (i * longer);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}