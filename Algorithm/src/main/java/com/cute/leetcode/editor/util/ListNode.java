package com.cute.leetcode.editor.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @AUTHOR: HYT
 * @DESCRIPTION
 */
public class ListNode {
    public Integer val;
    public String valStr;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    // 链表节点的构造函数
    // 使用arr为参数，创建一个链表，当前的ListNode为链表头节点
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    public ListNode(String[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.valStr = String.valueOf(arr[0]);
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    public ListNode(String valStr) {
        this.valStr = valStr;
    }

    //以当前节点为头节点的链表信息字符串 方便查看
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            if (StringUtils.isNotBlank(valStr)) {
                res.append(cur.valStr + "->");
                cur = cur.next;
            }
            if (cur.val != null) {
                res.append(cur.val + "->");
                cur = cur.next;
            }
        }
        res.append("NULL");
        return res.toString();
    }

}
