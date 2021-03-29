// 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
//
//
//
// 示例 1：
//
//
// 输入：s = "1 + 1"
// 输出：2
//
//
// 示例 2：
//
//
// 输入：s = " 2-1 + 2 "
// 输出：3
//
//
// 示例 3：
//
//
// 输入：s = "(1+(4+5+2)-3)+(6+8)"
// 输出：23
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 3 * 105
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
// s 表示一个有效的表达式
//
// Related Topics 栈 数学
// 👍 478 👎 0

package com.cute.leetcode.editor.cn;

// 基本计算器

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @date 2021-03-10 23:06:50
 * @author tommywing
 * @description
 */
public class P224_BasicCalculator {
  public static void main(String[] args) {
    // test code
    Solution solution = new P224_BasicCalculator().new Solution();
    solution.calculate("(1+(4+5+2)-3)+(6+8)");
  }
  // question code
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int calculate(String s) {
      char[] ch = s.toCharArray();
      int len = ch.length;

      Deque<Integer> stack = new ArrayDeque<>();
      for (int i = 0; i < len; i++) {
        switch (ch[i]) {
          case '(':
          case ')':
          case ' ':
            break;
          case '+':
            stack.addLast(stack.removeLast() + ch[++i]-48);
            break;
          case '-':
            stack.addLast(stack.removeLast() - ch[++i]-48);
            break;
          default:
            stack.addLast(ch[i]-48);
            break;
        }
      }
      int res = stack.pop();
      System.out.println(stack.pop());
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
