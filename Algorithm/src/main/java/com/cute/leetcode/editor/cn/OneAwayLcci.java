//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 字符串 动态规划 
// 👍 28 👎 0

package com.cute.leetcode.editor.cn;
public class OneAwayLcci {
    public static void main(String[] args) {
        Solution solution = new OneAwayLcci().new Solution();
        System.out.println(solution.oneEditAway("pale","ple"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         *
         * @param first
         * @param second
         * @return
         */
    public boolean oneEditAway(String first, String second) {
        char[] f=first.toCharArray();
        char[] s=second.toCharArray();
        int start1=0,start2=0;
        int end1=f.length-1,end2=s.length-1;
        while(start1<f.length&&start2<s.length){
            if(f[start1]==s[start2]){
                start1++;
                start2++;
            }else{
                break;
            }
        }while(end1>=0&&end2>=0){
            if(f[end1]==s[end2]){
                end1--;
                end2--;
            }else{break;}
        }
        return end1-start1<1 && end2-start2<1;
    }

    public boolean onEditAway2(String first,String second){

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}