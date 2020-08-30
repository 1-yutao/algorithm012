/**
 * 默写【深度优先搜索DFS】与【广度优先搜索BFS】的模板代码
 */

 /**
  * 深度优先搜索
        思路：递归
     例子：二叉树的层序遍历
  */
 public List<List<Integer>> levelOrder(TreeNode root) {
     if (root == null)  return Collections.emptyList();

     List<List<Integer>> resultList = new ArrayList<>();
     _levelOrder(root, 0, resultList);
     
    return resultList;
 }

 private void _levelOrder(TreeNode root, int level, List<List<Integer>> resultList) {
     if (resultList.size() == level) {
         resultList.add(new ArrayList<Integer>());
     }
     
     resultList.get(level).add(root.val);

     if (root.left != null)
        _levelOrder(root.left, level + 1, resultList);
    
    if (root.right != null)
        _levelOrder(root.right, level + 1, resultList);
 }


 /**
  * 广度优先
        思路：用队列记录元素
    例子：二叉树每行中找出最大值
  */
public List<Integer> largestValues(TreeNode root) {
    if (root == null) return Collections.emptyList();

    List<Integer> resultList = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        int max = Integer.MIN_VALUE;
        int currSize = queue.size();
        while (currSize --> 0) {
            TreeNode node = queue.poll();
            max = Math.max(max, node.val);

            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        resultList.add(max);
    }
    return resultList;
}