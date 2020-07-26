package org.millet.algorithm.week_03;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历中构造二叉树
 *
 * Created by yutao
 * Create date 2020/7/23 20:31
 */
public class BuildTree {

    /**

     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;

        Map<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0 ; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree2(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    /*
     *
     * preorder [3,9,4,5,20,15,7]
     *           | -----
     *         pStart
     *
     * inorder [4,9,5,3,15,20,7]
     *          -----
     *         leftNum
     */
    private TreeNode buildTree2(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> map) {
        //写递归终止条件
        if (pStart >= pEnd) return null;

        TreeNode root = new TreeNode(preorder[pStart]);
        int rootIndex = map.get(preorder[pStart]);      //从中序数组中找到root下标
        int leftNum = rootIndex - iStart;               //计算左子树的长度
        root.left = buildTree2(preorder, pStart + 1, pStart + 1 + leftNum, inorder, iStart, rootIndex, map);
        root.right = buildTree2(preorder, pStart + 1 + leftNum, pEnd, inorder, rootIndex + 1, iEnd, map);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if ( preorder == null || inorder == null || preorder.length != inorder.length) return null;

        Map<Integer, Integer> map = new HashMap<>(preorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    /**
     * 从preorder数组中取数据构建节点
     * @param preorder
     * @param pStart
     * @param pEnd
     * @param inorder
     * @param iStart
     * @param iEnd
     * @return
     */
    private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> map) {
        //写递归终止条件
        if (pStart == pEnd) return null;
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        int leftNum = rootIndex - iStart;       //左子树的长度，也用来计算右子树下标
        root.left = buildTree(preorder, pStart + 1, pStart + 1 + leftNum, inorder, iStart, rootIndex, map);
        root.right = buildTree(preorder, pStart + 1 + leftNum, pEnd, inorder, rootIndex + 1, iEnd, map);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode lefeOne = new TreeNode(9);
        TreeNode rightOne = new TreeNode(20);
        TreeNode rightLiftTwo = new TreeNode(15);
        TreeNode rightRigTwo = new TreeNode(7);

        root.left = lefeOne;
        root.right = rightOne;

        rightOne.left = rightLiftTwo;
        rightOne.right = rightRigTwo;

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        BuildTree buildTree = new BuildTree();
        TreeNode result = buildTree.buildTree2(preorder, inorder);
        System.out.println(result);
    }
}
