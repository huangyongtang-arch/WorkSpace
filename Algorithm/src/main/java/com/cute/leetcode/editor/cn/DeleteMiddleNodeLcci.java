//实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。 
//
// 
//
// 示例： 
//
// 输入：单向链表a->b->c->d->e->f中的节点c
//结果：不返回任何数据，但该链表变为a->b->d->e->f
// 
// Related Topics 链表 
// 👍 79 👎 0


package com.cute.leetcode.editor.cn;

//删除中间节点

import com.cute.leetcode.editor.util.ListNode;

/**
 * @author tommywing
 * @date 2021-02-09 16:20:02
 * @description
 */
public class DeleteMiddleNodeLcci {
    public static void main(String[] args) {
        //test code
        Solution solution = new DeleteMiddleNodeLcci().new Solution();
        solution.deleteNode(new ListNode(new int[]{4,5,1,9}));
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
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
