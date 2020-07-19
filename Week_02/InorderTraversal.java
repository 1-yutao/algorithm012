package org.millet.algorithm.week_02;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 二叉树的中序遍历
 * 解题：
 *  方法一： 递归
 *  方法二：迭代
 * Created by yutao
 * Create date 2020/7/17 16:35
 */
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootRight = new TreeNode(2);
        root.right = rootRight;
        TreeNode twoL = new TreeNode(3);
        TreeNode twoR = new TreeNode(4);
        rootRight.left = twoL;
        rootRight.right = twoR;

        InorderTraversal in = new InorderTraversal();
        List<Integer> resultList = in.inorderTraversal2(root);
        System.out.println(Arrays.toString(resultList.toArray()));
    }

    /**
     * 迭代
     *  默写第二遍
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        while (currNode != null || !stack.isEmpty()){
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            resultList.add(currNode.val);
            currNode = currNode.right;
        }
        return resultList;
    }

    /**
     * 迭代方式实现
     * 思路：嵌套循环，内循环负责左节点入栈，内循环结束后取栈顶元素，再取右节点
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        while (currNode != null || !stack.isEmpty()){
            while (currNode != null){
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            resultList.add(currNode.val);
            currNode = currNode.right;
        }
        return resultList;
    }
    /**
     * 递归方式实现
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> resultList = new ArrayList<>();
        inorderTraversal(root, resultList);
        return resultList;
    }

    private void inorderTraversal(TreeNode root, List<Integer> resultList){
        if (root == null) return;
        if(root.left != null)
            inorderTraversal(root.left, resultList);
        resultList.add(root.val);
        if(root.right != null)
            inorderTraversal(root.right, resultList);
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
