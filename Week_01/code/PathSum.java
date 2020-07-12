package org.millet.algorithm.week_01;

/**
 * Created by yutao
 * Create date 2020/7/7 21:17
 */
public class PathSum {

    public static void main(String[] args) {
        /*
            1、目标 逐一减去左右子节点，出现的情况：
                匹配：等于0且到叶节点； 不匹配：到叶节点且不等于0
         */

        PathSum pathSum = new PathSum();
        TreeNode root = pathSum.new TreeNode(5);

        TreeNode rootLeft = pathSum.new TreeNode(4);
        TreeNode rootRight = pathSum.new TreeNode(8);
        root.left = rootLeft;
        root.right = rootRight;

        TreeNode left4 = pathSum.new TreeNode(11);
        rootLeft.left = left4;

        TreeNode left411 = pathSum.new TreeNode(7);
        TreeNode right411 = pathSum.new TreeNode(2);
        left4.left = left411;
        left4.right = right411;

        TreeNode left8 = pathSum.new TreeNode(13);
        TreeNode right8 = pathSum.new TreeNode(4);
        rootRight.left = left8;
        rootRight.right = right8;

        TreeNode right84 = pathSum.new TreeNode(4);
        right8.right = right84;

        boolean result = pathSum.hasPathSum(root, 22);
        System.out.println(result);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        int diff = sum - root.val;
        return hasPathSum(root.left, diff) ||
                hasPathSum(root.right, diff);
    }

    public boolean hasPathSum2(TreeNode root, int sum){
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum2(root.left, sum - root.val) ||
                hasPathSum2(root.right, sum = root.val);
    }




    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
