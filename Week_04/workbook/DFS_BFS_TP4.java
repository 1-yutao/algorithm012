/**
 * 深度优先
 * 
 * 算法：递归
 * 
 * 例：二叉树的层序遍历
 */

 public List<List<Integer>> levelOrder(TreeNode root) {
     if (root == null) return Collections.emptyList();

     List<List<Integer>> resultList = new ArrayList<>();
     _levelOrder(root, 0, resultList);
     return resultList;
 }

 private void _levelOrder(TreeNode root, int level, List<List<Integer>> resultList){
     if (level == resultList.size()) {
         resultList.add(new ArrayList<Integer>());
     }

     resultList.get(level).add(root.val);

     if (root.left != null) 
        _levelOrder(root, level + 1, resultList);
    
    if (root.right != null)
        _levelOrder(root.right, level +1, resultList);
    
 }


 /**
  * 广度优先
  *     思路：使用队列
  * 例：二叉树每层的最大值
  */

  public List<Integer> largestValues(TreeNode root) {
      if (root == null) return Collections.emptyList();

      List<Integer> resultList = new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>(); 
      queue.offer(root);

      while (!queue.isEmpty()) {
          int size = queue.size();
          int max = Integer.MIN_VALUE;
          while (size --> 0) {
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