//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
//
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 284 👎 0


package com.cute.leetcode.editor.cn;

//字符串的排列

/**
 * @author tommywing
 * @date 2021-02-10 20:48:27
 * @description
 */
public class P567_PermutationInString {
    public static void main(String[] args) {
        //test code
        Solution solution = new P567_PermutationInString().new Solution();
//        solution.checkInclusion("ab", "eidboaoo");
//        solution.checkInclusion("ab", "eidbaooo");
        solution.checkInclusion("adc", "dcda");
    }

    //question code
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int[] ch = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                ch[s1.charAt(i) - 'a']++;
            }

            int windowSize = s1.length() - 1;

            for (int i = windowSize; i < s2.length(); i++) {
                int[] windowCh = new int[26];
                for (int j = i - windowSize; j <= i; j++) {
                    windowCh[s2.charAt(j) - 'a']++;
                }
                for (int j = 0; j < windowCh.length; j++) {
                    if (windowCh[j] != ch[j]){break;}
                    if (j == windowCh.length - 1 && windowCh[j] == ch[j]){
//                        System.out.println(true);
                        return true;
                    }
                }

            }
//            System.out.println(false);
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}