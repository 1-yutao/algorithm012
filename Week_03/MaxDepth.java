package org.millet.algorithm.week_03;

import java.sql.Struct;

/**
 * 二叉树的最大深度
 * Created by yutao
 * Create date 2020/7/22 15:12
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null ) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }
}
