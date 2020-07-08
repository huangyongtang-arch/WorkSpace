//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
// Related Topics 哈希表 字符串 
// 👍 25 👎 0

package com.cute.leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class PalindromePermutationLcci {
    public static void main(String[] args) {
        Solution solution = new PalindromePermutationLcci().new Solution();
//        boolean b = solution.canPermutePalindrome("aabbccc");
//        System.out.println(b);
//        System.out.println(solution.canPermutePalindrome("aaaa"));
//        System.out.println(solution.canPermutePalindrome("aaa"));
//        System.out.println(solution.canPermutePalindrome("catetac"));
//        System.out.println(solution.canPermutePalindrome("aabbcccc"));
//        System.out.println(solution.canPermutePalindrome("catettc"));

        System.out.println(solution.canPermutePalindrome2("catettc"));
        System.out.println(solution.canPermutePalindromeOptimize("catetac"));
        System.out.println(solution.canPermutePalindromeOptimize("aaaaabbcccc"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @param s
         * @return
         * @Wrong
         * @Description"aabbccc"的时候不行
         */
        public boolean canPermutePalindrome1(String s) {
            Set<Character> set = new HashSet<>();
            for (char i : s.toCharArray()) {
                set.add(i);
            }
            if (set.size() == 1) {
                return true;
            }
            if (set.size() == 0) {
                return false;
            }
            return (s.length() % 2 == 0) ? set.size() == s.length() / 2 : set.size() - 1 == s.length() / 2;
        }

        /**
         * @True 答对了
         * @param s
         * @return
         */
        public boolean canPermutePalindrome(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char i : s.toCharArray()) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }
            int sole = 0;
            if (s.length() % 2 == 0) {
                for (int i : map.values()) {
                    if (i % 2 != 0) {
                        return false;
                    }
                }
                return true;
            } else {
                for (int i : map.values()) {
                    if (i % 2 != 0) {
                        sole++;
                    }
                }
                return sole == 1;
            }
        }

        /**
         * @Description My Code Optimize
         * @param s
         * @return
         */
        public boolean canPermutePalindromeOptimize(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char i : s.toCharArray()) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }
            int sole = 0;
            for (int i : map.values()) {
                if (i % 2 == 1) {
                    sole++;
                }
            }
            return sole<=1;
        }

        /**
         * 定义一个长度为128空数组，遍历字符数组，将字符作为数组下标每出现一次++；
         * 然后再循环自己定义的数组，如果出现奇数的次数小于等于1，则说明字符串重新排列后能对称，即是回文
         * <p>
         * 作者：hei-ye-wen-bai-tian-4
         * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci/solution/tong-su-yi-dong-0mstong-guo-jie-fa-by-hei-ye-wen-b/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         * @Answer
         * @param s
         * @return
         */
        public boolean canPermutePalindrome2(String s) {
            int[] arr = new int[128];
            for (int c : s.toCharArray()) {
                arr[c]++;
            }
            int flag = 0;
            for (int i : arr) {
                if (i % 2 == 1) {
                    flag++;
                }
            }
            if (flag <= 1) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}