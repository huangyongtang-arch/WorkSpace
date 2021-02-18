//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
// Related Topics 链表 双指针 
// 👍 54 👎 0


package com.cute.leetcode.editor.cn;

//返回倒数第 k 个节点

import com.cute.leetcode.editor.util.ListNode;

/**
 * @author tommywing
 * @date 2021-02-09 15:46:09
 * @description
 */
public class KthNodeFromEndOfListLcci {
    public static void main(String[] args) {
        //test code
        Solution solution = new KthNodeFromEndOfListLcci().new Solution();
        solution.kthToLast(new ListNode(new int[]{1, 2}), 1);
    }
    //question code
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int kthToLast(ListNode head, int k) {
            if (head == null) {
                return -1;
            }
            if (head.next == null) {
                return head.val;
            }

            ListNode dump = head;
            //计算链表长度
            int cnt = 1;
            while (dump.next != null) {
                dump = dump.next;
                cnt++;
            }

            ListNode res = head;
            for (int i = 1; i < cnt + 1; i++) {
                if (i == cnt - k + 1) {
                    return res.val;
                }
                res = res.next;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}