//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 链表 
// 👍 88 👎 0


package com.cute.leetcode.editor.cn;

//移除重复节点

import com.cute.leetcode.editor.util.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author tommywing
 * @date 2021-02-09 13:48:15
 * @description
 */
public class RemoveDuplicateNodeLcci {
    public static void main(String[] args) {
        //test code
        Solution solution = new RemoveDuplicateNodeLcci().new Solution();
        ListNode listNode = new ListNode(new int[]{1, 2, 3, 3, 2, 1});
        solution.removeDuplicateNodes(listNode);
    }

    //question code
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {
            ListNode dump = head;
            List<Integer> list = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            list.add(head.val);
            while (dump.next != null) {
                int val = dump.next.val;
                if (list.contains(val)) {
                    dump.next = dump.next.next;
                } else {
                    dump = dump.next;
                    list.add(val);
                }
            }
            dump.next = null;

//            System.out.println(head.toString());
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}