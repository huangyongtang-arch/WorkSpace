package com.cute.leetcode.editor.util;

/**
 * @AUTHOR: HYT
 * @DESCRIPTION
 */
public class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
