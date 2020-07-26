package org.millet.algorithm.week_03;

/**
 * 旋转二叉树
 * Created by yutao
 * Create date 2020/7/21 20:00
 */
public class InvertTree {

    private TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null)
            invertTree(root.left);
        if (root.right != null)
            invertTree(root.right);
        return root;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        InvertTree invertTree = new InvertTree();
        InvertTree.TreeNode root = invertTree.new TreeNode(5);

        InvertTree.TreeNode rootLeft = invertTree.new TreeNode(4);
        InvertTree.TreeNode rootRight = invertTree.new TreeNode(8);
        root.left = rootLeft;
        root.right = rootRight;

        InvertTree.TreeNode left4 = invertTree.new TreeNode(11);
        rootLeft.left = left4;

        InvertTree.TreeNode left411 = invertTree.new TreeNode(7);
        InvertTree.TreeNode right411 = invertTree.new TreeNode(2);
        left4.left = left411;
        left4.right = right411;

        InvertTree.TreeNode left8 = invertTree.new TreeNode(13);
        InvertTree.TreeNode right8 = invertTree.new TreeNode(4);
        rootRight.left = left8;
        rootRight.right = right8;

        InvertTree.TreeNode right84 = invertTree.new TreeNode(4);
        right8.right = right84;

        invertTree.invertTree(root);

        System.out.println(root);


    }

}
