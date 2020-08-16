学习笔记
一、深度优先搜索代码模板：
关键字：递归

public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return Collections.emptyList();

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
        _levelOrder(root.left, level + 1);
    
    if (root.right != null)
        _levelOrder(root.right, level + 1, resultList);
}

二、广度优先搜索模板代码
    关键字：队列、层层遍历

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> resultList = new ArrayList<>();

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> valList = new ArrayList<>();
            for (int i = 0; i < size; i++) {    //消费队列，并将子节点存入队列
                TreeNode node = nodes.poll();
                valList.add(node.val);
                if (node.left != null)
                    nodes.add(node.left);
                if (node.right != null)
                    nodes.add(node.right);
            }
            resultList.add(valList);
        }
        return resultList;
    }

三、二分查找代码模板

public int binarySearch(int[] array, int target) {
    int left = 0, right = array - 1, mid;

    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
}