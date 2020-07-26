package org.millet.algorithm.week_03;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树的公共祖先
 *
 * Created by yutao
 * Create date 2020/7/23 15:13
 */
public class LowestCommonAncestor {

    /**
     * 递归
     * 存储父节点： 将先命中的元素由下往上依次存储父节点到队列中，后命中的节点由下往上依次在队列中能查找，找到即时最小公共祖先
     * ！！！！失败！！！！
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor_02(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, Integer> parentMap = new HashMap<>();
        p_dfs(root, p, parentMap);
        q_dfs(root, q, parentMap);
        return resultNode;
    }

    private boolean q_dfs(TreeNode root, TreeNode q, Map<Integer, Integer> parentMap) {
        if (root == null) return false;

        boolean plson = q_dfs(root.left, q, parentMap);
        boolean prson = q_dfs(root.right, q, parentMap);

        if (plson || prson){
            if (plson) {
                Integer r = parentMap.get(root.left.val);
                if (r != null && resultNode == null) {
                    resultNode = root.left;
                    return true;
                }
            }
            if (prson) {
                Integer r = parentMap.get(root.right.val);
                if (r != null && resultNode == null) {
                    resultNode = root.right;
                    return true;
                }
            }

            Integer r = parentMap.get(root.val);
            if (r != null && resultNode == null) {
                resultNode = root;
                return true;
            }
        }

        return root.val == q.val;
    }

    private boolean p_dfs(TreeNode root, TreeNode p, Map<Integer, Integer> parentMap) {
        if (root == null) return false;

        boolean plson = p_dfs(root.left, p, parentMap);
        boolean prson = p_dfs(root.right, p, parentMap);
        if (plson || prson){
            parentMap.put(root.val, root.val);
            if (plson){
                parentMap.put(root.left.val, root.left.val);
            }
            if (prson){
                parentMap.put(root.right.val, root.right.val);
            }
            return true;
        }

        return root.val == p.val;
    }


    TreeNode resultNode;
    public LowestCommonAncestor(){
        resultNode = null;
    }

    /**
     * 递归
     * 合并左右节点返回和当前节点判断的结果
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return resultNode;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);

        /*
          第一种情况：lson && rson 左右子节点都返回true是
          第二中情况：(root.val == p.val || root.val == q.val) && (lson || rson)
                    命中当前节点的某一个或多个，或者子节点命中一个

         */
        if ((lson && rson) ||
                ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            resultNode = root;
        }

        return lson || rson || (root.val == p.val || root.val == q.val);
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
