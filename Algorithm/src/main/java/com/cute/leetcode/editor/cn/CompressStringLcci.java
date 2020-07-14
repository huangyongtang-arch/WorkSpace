//字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
//有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。 
//
// 示例1: 
//
// 
// 输入："aabcccccaaa"
// 输出："a2b1c5a3"
// 
//
// 示例2: 
//
// 
// 输入："abbccd"
// 输出："abbccd"
// 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 50000]范围内。 
// 
// Related Topics 字符串 
// 👍 44 👎 0

package com.cute.leetcode.editor.cn;

import java.util.Arrays;

public class CompressStringLcci {
    public static void main(String[] args) {
        Solution solution = new CompressStringLcci().new Solution();
        System.out.println(solution.compressString("abbccd"));
        System.out.println(solution.compressString("a"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String compressString(String S) {
        int count=1,i=0,j=1;
        char[] ch=S.toCharArray();
        StringBuilder sb = new StringBuilder();
        // TODO1
        if(S.length()==1){
            sb.append(ch[i]);
        }
        else{
        while(j<ch.length && i<ch.length){
            if(ch[i]==ch[j]){
                count++;
                j++;
            }
            // 只在不同时才存放字符串的副作用就是
            // 当计数到后面一批或者只有一批相同的字符时没有存放进去，解决办法：注释TODO2
            // 当字符串只有一个时，也没能存放进去 解决：注释TODO1
            else if(ch[i]!=ch[j]){
                sb.append(ch[i]);
                sb.append(count);
                i=j;
                j++;
                count=1;
            }
            // TODO2
            // 当计数到后面一批或者只有一批相同的字符时存放字符串
            // 当字符串只有一个时，没能存放进去 解决:注释TODO1
            if(count>=1&&j==ch.length){
                sb.append(ch[j-1]);
                sb.append(count);
            }
        }
        }
        if(sb.length()>=S.length()){
            return S;
        }
        String res = sb.toString();
        return res;
    }



}
//leetcode submit region end(Prohibit modification and deletion)

}