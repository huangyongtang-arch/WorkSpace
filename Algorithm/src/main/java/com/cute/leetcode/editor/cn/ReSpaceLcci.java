//哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’
//t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一
//本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。 
//
//
// 注意：本题相对原题稍作改动，只需返回未识别的字符数 
//
// 
//
// 示例： 
//
// 输入：
//dictionary = ["looked","just","like","her","brother"]
//sentence = "jesslookedjustliketimherbrother"
//输出： 7
//解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
// 
//
// 提示： 
//
// 
// 0 <= len(sentence) <= 1000 
// dictionary中总字符数不超过 150000。 
// 你可以认为dictionary和sentence中只包含小写字母。 
// 
// Related Topics 记忆化 字符串 
// 👍 53 👎 0

package com.cute.leetcode.editor.cn;

import java.util.Arrays;

public class ReSpaceLcci {
    public static void main(String[] args) {
        Solution solution = new ReSpaceLcci().new Solution();
        solution.respace(new String[]{"bt", "vbtbvtvvbbvtbvvbbbvbtbbv", "bvvbbbvvvbvttbtbvtvtvvbttbbbtvvvb", "btttbvbbbtbbtbvvttbvbvtvbtbbttb", "bt", "vvbvbvbvtbvbvvvvtv", "tbvvvtttvtbvbtttvvbtvvvvtvvbvvtvvbbvbbbvb", "v", "bvb", "vvtbvtvbttbttvvbvttbt", "btbtbtttvbbtbttbtvvttbvtbtvtbvvtbbbb", "bttbvbbttvvbtvvvvb", "bvvbvbvttbvtbvvtbttvvvvtvbtvbttbbvvtvtvv", "vbtttt", "btbvbbbvbtvtbvvv", "b", "tbtbtv", "vbvbbvvbvbbvvb", "vbvvtvbvbvbttvbvbtvbtbtvtbvbbtb", "bvvbvvttttttbtvvvttvbvtvvbvtbtvtbvttvvtbt", "bvtbttv", "bbbt", "vtt", "ttvv", "b", "vbb", "vtvvbtttvtbbvvbbtbb", "vvv", "vvvvbbbtbbbvbbbb", "ttvvbtvv", "v", "btvbbvtbbvbvtvttvvbbbtbvvvtbtb", "vv", "btbttbtbbvbvvbvttbttvtbbtbvtttvbbtbbtvtvvvvbbttvtvvbbbv", "ttvbbbbttbtbtb", "tvvbvbvvb", "vv", "ttbttvtvbtbbbbv", "bvvvtbbvvvbtvbvtvtvvvvbb", "vtbvvbvvvvvttvbbttbbvtvt", "tbvbbt", "b", "v", "tvbbtvvtvvtbtbttvvvb", "tbttbttbbbtbtvtvtvtbbbvvtbbbvbbvvvbbttvvt", "bbvttvtvvtbvbbttvbbtbvvttbvbvbtbvvvbbbvbvbvbtvbtvvvtvvtbttbttbbvbbbttvvvbvvtb", "vttvvbvv", "tbttbvvttvbtvvtbbvvv", "bvbbbbbbbb", "vtbvvtbbvtt", "bvttbvvbvb", "tvttttbbvvvbbtttvvv"},
                "btbvtttttbvttbvvbbtvvbvbvvbtbtbtvbtttbvbbbtbbtbvvttbvbvtvbtbbttbvvbvbtttbvttbvvbbvvv");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int respace(String[] dictionary, String sentence) {
            Arrays.sort(dictionary, (x, y) -> (y.length() - x.length()));
//        for (String i:dictionary
//             ) {
//            System.out.println(i);
//        }
            for (int i = 0; i < dictionary.length; i++) {
                String regex = "" + dictionary[i] + "";
                sentence = sentence.replaceAll(regex, "");
                System.out.println(sentence);
                int j = sentence.length();
                System.out.println(j);
            }
            System.out.println(sentence);
            return sentence.length();
        }


        /**
         * 定义 \textit{dp}[i]dp[i] 表示考虑前 ii 个字符最少的未识别的字符数量，从前往后计算 \textit{dp}dp 值。
         * 考虑转移方程，每次转移的时候我们考虑第 j(j\le i)j(j≤i) 个到
         * 第 ii 个字符组成的子串 \textit{sentence}[j-1\cdots i-1]sentence[j−1⋯i−1]
         * （注意字符串下标从 00 开始）是否能在词典中找到，如果能找到的话按照定义转移方程即为
         * \textit{dp}[i]=\min(\textit{dp}[i],\textit{dp}[j-1])
         * dp[i]=min(dp[i],dp[j−1])
         * 否则没有找到的话我们可以复用 \textit{dp}[i-1]dp[i−1] 的状态再加上当前未被识别的第 ii 个字符，因此此时 \textit{dp}dp 值为
         * \textit{dp}[i]=dp[i-1]+1
         * dp[i]=dp[i−1]+1
         * 最后问题化简成了转移的时候如何快速判断当前子串是否存在于词典中，
         * 与「单词拆分」类似我们可以选择用哈希表来优化，但笔者实测下来速度很慢，
         * 因为用哈希表来实现本身有两个问题，一个是哈希表本身的常数很大，
         * 还有一个是我们在枚举子串是否在词典中的时候有些其实是没有必要的枚举。
         * 简单举例，如果我们有词典：['aabc', 'babc', 'cbc'] ，
         * 但是我们在倒序枚举的时候检查 dc 这个子串没出现在词典中以后我们就没必要再接着往前枚举是否有合法的子串了，
         * 因为 dc 本身已经不是词典中「任意一个单词的后缀」，
         * 我们再接着枚举 *dc 或者 **dc 判断其是否在词典中都是无用功。
         * 因此最终笔者选择了用字典树 \textit{Trie}Trie 来优化查找，
         * \textit{Trie}Trie 是一种最大程度利用多个字符串前缀信息的数据结构，
         * 它可以在 O(w)O(w) 的时间复杂度内判断一个字符串是否是一个字符串集合中某个字符串的前缀，
         * 其中 ww 代表字符串的长度。这里具体实现不再展开，我们只讲怎么使用。上文提到了哈希表实现的时候会出现很多冗余的判断，
         * 最关键的一点就是当前枚举的子串已经不再是词典中「任意一个单词的后缀」，这点我们可以利用 \textit{Trie}Trie 来解决。
         * 我们将词典中所有的单词「反序」插入字典树中，
         * 然后每次转移的时候我们从当前的下标 ii 出发倒序遍历 i-1,i-2,\cdots,0i−1,i−2,⋯,0。
         * 在 \textit{Trie}Trie 上从根节点出发开始走，
         * 直到走到当前的字符 \textit{sentence}[j]sentence[j] 在 \textit{Trie}Trie 上没有相应的位置，
         * 说明 \textit{sentence}[j\cdots i-1]sentence[j⋯i−1] 不存在在词典中，
         * 且它已经不是「任意一个单词的后缀」，此时我们直接跳出循环即可。
         * 否则，我们需要判断当前的子串是否是一个单词，
         * 这里我们直接在插入 \textit{Trie}Trie 的时候在单词末尾的节点打上一个 \textit{isEnd}isEnd 的标记即可，
         * 这样我们在走到某个节点的时候就可以判断是否是一个单词的末尾并根据状态转移方程更新我们的 \textit{dp}dp 值。
         *
         * @param dictionary
         * @param sentence
         * @return
         */
        public int respace1(String[] dictionary, String sentence) {
            int n = sentence.length();

            Trie root = new Trie();
            for (String word : dictionary) {
                root.insert(word);
            }

            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= n; ++i) {
                dp[i] = dp[i - 1] + 1;

                Trie curPos = root;
                for (int j = i; j >= 1; --j) {
                    int t = sentence.charAt(j - 1) - 'a';
                    if (curPos.next[t] == null) {
                        break;
                    } else if (curPos.next[t].isEnd) {
                        dp[i] = Math.min(dp[i], dp[j - 1]);
                    }
                    if (dp[i] == 0) {
                        break;
                    }
                    curPos = curPos.next[t];
                }
            }
            return dp[n];
        }


        class Trie {
            public Trie[] next;
            public boolean isEnd;

            public Trie() {
                next = new Trie[26];
                isEnd = false;
            }

            public void insert(String s) {
                Trie curPos = this;

                for (int i = s.length() - 1; i >= 0; --i) {
                    int t = s.charAt(i) - 'a';
                    if (curPos.next[t] == null) {
                        curPos.next[t] = new Trie();
                    }
                    curPos = curPos.next[t];
                }
                curPos.isEnd = true;
            }
        }
    }}
