package org.millet.algorithm.week_02;

import java.util.*;

/**
 * 二叉树的前序遍历
 * 解题：
 *  方法一：递归
 *  方法二：迭代
 * Created by yutao
 * Create date 2020/7/18 9:18
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootRight = new TreeNode(2);
        root.right = rootRight;
        TreeNode twoL = new TreeNode(3);
        TreeNode twoR = new TreeNode(4);
        rootRight.left = twoL;
        rootRight.right = twoR;

        PreorderTraversal preorderTraversal = new PreorderTraversal();
        List<Integer> resultList = preorderTraversal.preorderTraversal2(root);
        System.out.println(Arrays.toString(resultList.toArray()));
    }

    /**
     * 迭代方式
     *  思路： 与N叉树的遍历方式一样，将
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            resultList.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return resultList;
    }


    /**
     * 递归方式实现
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> resultList = new ArrayList<>();
        preorderTraversal(root, resultList);
        return resultList;
    }

    private void preorderTraversal(TreeNode root, List<Integer> resultList){
        if (root == null) return;
        resultList.add(root.val);
        if(root.left != null)
            preorderTraversal(root.left, resultList);
        if(root.right != null)
            preorderTraversal(root.right, resultList);
    }

    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

}
