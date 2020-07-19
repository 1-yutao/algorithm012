package org.millet.algorithm.week_02;

import java.util.*;

/**
 * N叉树的前序遍历
 * 题目：给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解题：
 *  方法一：递归
 *  方法二：迭代
 *
 * Created by yutao
 * Create date 2020/7/17 11:19
 */
public class Preorder {

    public static void main(String[] args) {
        Preorder preorder = new Preorder();

        Node root = preorder.new Node(1);

        List<Node> rootChildrens = new ArrayList<>();
        Node childRoot1 = preorder.new Node(2);
        Node childRoot2 = preorder.new Node(3);
        Node childRoot3 = preorder.new Node(4);
        rootChildrens.add(childRoot1);
        rootChildrens.add(childRoot2);
        rootChildrens.add(childRoot3);
        root.children = rootChildrens;

        Node child1children1 = preorder.new Node(5);
        Node child1children2 = preorder.new Node(6);
        Node child1children3 = preorder.new Node(7);
        List<Node> child1childrens = new ArrayList<>();
        child1childrens.add(child1children1);
        child1childrens.add(child1children2);
        child1childrens.add(child1children3);
        childRoot1.children = child1childrens;


        List<Integer> result = preorder.preorder2(root);
        System.out.println(Arrays.toString(result.toArray()));
    }

    /**
     * 迭代法
     *  思路：
     *  loop : 取栈头 --> 将子节点按倒叙压栈
     *  leetcode执行结果通过，但只击败38%的人，还不如递归快
     *  要点：将子节点压栈时必须要倒叙
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        if (root == null) return Collections.emptyList();
        List<Integer> resultList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            resultList.add(node.val);
            List<Node> childrens = node.children;
            if(childrens == null) continue;
            for (int i = childrens.size() -1; i >= 0; i--){
                stack.push(childrens.get(i));
            }
        }

        return resultList;
    }

    /**
     * 递归调用 N叉树的前序遍历
     *   递归的关键是先写结束语句
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(Node root, List<Integer> result) {

        result.add(root.val);
        List<Node> children = root.children;
        if(children == null)
            return ;

        for (Node node : children) {
            preorder(node, result);
        }

    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
