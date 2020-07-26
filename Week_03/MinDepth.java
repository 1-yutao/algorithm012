package org.millet.algorithm.week_03;

/**
 * 二叉树的最小深度
 * Created by yutao
 * Create date 2020/7/22 15:44
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null ) return 0;

        if (root.left == null && root.right == null)
            return 1;

        int minDepth = Integer.MAX_VALUE;
        minDepth = _depthCount(root, minDepth);
        return minDepth;
    }

    private int _depthCount(TreeNode root, int minDepth) {
        if(root == null) return 0;
        if (root.left != null)
            minDepth = Math.min(_depthCount(root.left, minDepth), minDepth);
        if (root.right != null)
            minDepth = Math.min(_depthCount(root.right, minDepth), minDepth);
        return minDepth + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
