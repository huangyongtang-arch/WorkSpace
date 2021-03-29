//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 612 👎 0


package com.cute.leetcode.editor.cn;

//分割回文串

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author tommywing
 * @date 2021-03-07 23:19:26
 * @description
 */
public class P131_PalindromePartitioning {
    public static void main(String[] args) {
        //test code
        Solution solution = new P131_PalindromePartitioning().new Solution();
    }

    //question code
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            int len = s.length();
            List<List<String>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            char[] chars = s.toCharArray();
            Deque<String> stack = new ArrayDeque<>();
            bfs(chars, 0, len, stack, res);

            return res;
        }

        void bfs(char[] chars, int index, int len, Deque<String> path, List<List<String>> res) {
            if (index == len) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = index; i < len; i++) {
                if (isPalindrome(chars, index, i)) {
                    path.addLast(new String(chars, index, i + 1 - index));
                    bfs(chars, i + 1, len, path, res);
                    path.removeLast();
                }
            }
        }

        boolean isPalindrome(char[] s, int left, int right) {
            if (s.length == 1) {
                return true;
            }
            while (left < right) {
                if (s[left] != s[right]) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}