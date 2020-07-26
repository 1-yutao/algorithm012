package org.millet.algorithm.week_03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 验证二叉搜索树
 *
 * Created by yutao
 * Create date 2020/7/21 21:09
 */
public class ValidBST {

    //----第五次 最优解--------------
    long pre = Long.MIN_VALUE;
    public boolean isValidBST_05(TreeNode root) {
        if (root == null) return true;
        //访问左子树
        if (!isValidBST_05(root.left)) return false;

        //如果当前节点小于中序遍历的前一个节点，说明不满足BST，返回false，否则继续遍历
        if (root.val < pre) {
            return false;
        }
        pre = root.val;

        return isValidBST_05(root.right);
    }

    //--------第四次 官方- 中序遍历
    public boolean isValidBST_04(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        //double inorder = -Double.MAX_VALUE;
        long inorder = -Long.MAX_VALUE;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    //-----第三次用官方解题思路---------------
    /**
     * 官方解题思路 -- 递归
     * @param root
     * @return
     */
    public boolean isValidBST_03(TreeNode root) {
        return _help(root, null, null);
    }

    private boolean _help(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;

        int curVal = root.val;
        if (lower != null && curVal <= lower) return false;
        if (upper != null && curVal >= upper) return false;

        if (!_help(root.left, curVal, upper)) return false;
        if (!_help(root.right, lower, curVal)) return false;

        return true;
    }


//-----------------------第二次的失败代码----------------------------------------
    /**
     * 失败
     * @param root
     * @return
     */
    public boolean isValidBST_02(TreeNode root) {
        if (root == null) return true;
        int currVal = root.val;
        if (root.left != null){
            if (currVal <= root.left.val)
                return false;
        }
        if (root.right != null){
            if (currVal >= root.right.val)
                return false;
        }

        boolean lr = _isLeftValid(root.left, root.val);
        boolean rr = _isRightValid(root.right, root.val);
        return lr && rr;
    }

    private boolean _isLeftValid(TreeNode root, int limit) {
        if (root == null) return true;
        int currVal = root.val;
        if (root.left != null) {
            int leftVal = root.left.val;
            if (currVal <= leftVal)
                return false;
        }
        if (root.right != null) {
            int rightVal = root.right.val;
            if (currVal >= rightVal || limit <= rightVal)
                return false;
        }
        return true;
    }

    private boolean _isRightValid(TreeNode root, int limit) {
        if (root == null) return true;
        int currVal = root.val;
        if (root.left != null) {
            int leftVal = root.left.val;
            if (currVal <= leftVal || leftVal <= limit)
                return false;
        }
        if (root.right != null) {
            int rightVal = root.right.val;
            if (currVal >= rightVal)
                return false;
        }
        return true;
    }

    //-----------------第一次的失败代码-----------------------------------
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return _isValid(root, root.val);
    }

    private boolean _isValid(TreeNode root, int limit) {
        int currVal = root.val;
        if (root.left != null) {
            int leftVal = root.left.val;
            if (currVal <= leftVal) {
                return false;
            }
        }
        if(root.right != null){
            int rigthVal = root.right.val;
            if (currVal >= rigthVal) {
                return false;
            }
        }
        boolean result = _isValid(root.left, limit);
        if(!result) return false;
        result = _isValid(root.right, limit);;
        if (!result)    return false;
        return true;
    }
//----------------------------------------------------------------------
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Integer[] treeDatas = new Integer[] {3,1,5,0,2,null,null,null,null,4,6,null,null,null,3};
        TreeNode root = generate(treeDatas);

        ValidBST validBST = new ValidBST();
        boolean result = validBST.isValidBST_03(root);
        System.out.println(result);
    }

    /**
     * 数组生成二叉树
     * 注意：数组中的null表示当前没有对应的子节点
     * @param treeDatas
     * @return
     */
    private static TreeNode generate(Integer[] treeDatas) {
        if (treeDatas == null || treeDatas.length == 0) return null;

        List<Integer> list = new LinkedList<>(Arrays.asList(treeDatas));
        return _buildTree(list);
    }

    private static TreeNode _buildTree(List<Integer> list) {
        if (list == null || list.size() == 0) return null;
        if (list.get(0) == null){
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(list.get(0));
        list.remove(0);
        root.left = _buildTree(list);
        root.right = _buildTree(list);

        return root;
    }


}
