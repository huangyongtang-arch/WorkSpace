//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 仅由小写英文字母组成。 
// 
// Related Topics 栈 
// 👍 144 👎 0


package com.cute.leetcode.editor.cn;

//删除字符串中的所有相邻重复项

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @date 2021-03-09 09:33:22
 * @author tommywing
 * @description
 */
public class P1047_RemoveAllAdjacentDuplicatesInString{
	 public static void main(String[] args) {
        //test code
	 	 Solution solution = new P1047_RemoveAllAdjacentDuplicatesInString().new Solution();
	 	 solution.removeDuplicates("abbaca");
	 }
    //question code
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String S) {
        char[] ch = S.toCharArray();
        int len = ch.length;
        StringBuilder res = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = len - 1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek() == ch[i]){
                stack.pop();
            }else {
                stack.push(ch[i]);
            }
        }
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
//        System.out.println(res);
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}