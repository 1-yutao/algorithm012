/**
 * 深度优先与广度优先算法 默写 第三遍
 */

 /*
    深度优先

    实现方式：递归
             判断左右儿子不为空，下钻

    常见题目：二叉树的层序遍历
 */

 public List<List<Integer>> levelOrder(TreeNode root) {
     if (root == null) Collections.emptyList();

     List<List<Integer>> resultList = new ArrayList<>();
     _levelOrder(TreeNode root, 0, resultList);

     return resultList;
 }

 private void _levelOrder(TreeNode root, int level, List<List<Integer>> resultList) {
     if (level == resultList.size()) {
         resultList.add(new ArrayList<Integer>());
     }

     resultList.get(level).add(root.val);

     if (root.left != null) 
        _levelOrder(root.left, level + 1, resultList);
    if (root.right != null)
        _levelOrder(root.right, level + 1, resultList);
 }


 /*
     广度优先算法
        使用队列记录节点

    题目：二叉树每行中找出最大值
 */

 public List<Integer> largestValues(TreeNode root) {
     if (root == null) return Collections.emptyList();

     List<Integer> resultList = new ArrayList<>();
     
     Oueue<TreeNode> queue = new LinkedList<>();
     queue.offer(root);

     while(!queue.isEmpty()) {
         int currSize = queue.size();
         int max = Integer.MIN_VALUES;
         while (currsize --> 0) {
            TreeNode node = queue.poll();
            max = Math.max(max, root.val);

            if (root.left != null)
                queue.offer(root.left);
            if (root.right != null)
                queue.offer(root.right);
         }
         resultList.add(max);
     }


     return resultList;
 }

