学习笔记
一、Trie树 
    发音同try, 是一种树数据结构。
    应用场景：1、拼写补全；2、拼写检查；3、IP路由最长前串匹配；4、九宫格打字预测；5、单词游戏

    经典问题：Hash表可以在O(1)的时间复杂度中找到一个单词，为什么还要用Trie树？
          答：hash无法高效的完成如下操作：1、找到具有相同前缀的全部键值；2、按字典序枚举字符串的数据集

    
    关联知识：二叉树的层序遍历
        关联知识点：自顶向下的编程方式
        经典的二叉树的广度优先搜索算法（BFS), 代码模板如下：

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return Collections.emptyList();

            List<List<Integer>> result = new ArrayList<>();
            _levelOrder(root, int level, result);

            return result;
        }

        private void _levelOrder(TreeNode root, int level, List<List<Integer>> result) {
            if (level == result.size()) {
                List<Integer> list = new ArrayList<Integer>();
                result.add(list);
            }

            result.get(level).add(root.val);

            if (root.left != null)
                _levelOrder(root.left, level + 1, result);

            if (root.right != null)
                _levelOrder(root.right, level + 1, result);
        }


二、并查集
    概念：并查集（DisjointSets) 是一种树型的数据结构，用于处理一些不想交集合的合并及查询问题。
        常常在使用中以森林来表示。
    主要操作：1、初始化：把每个点所在集合初始化为其自身，这个步骤在每次使用该数据结构时只需要执行一次，时间复杂度O(n)
        2、查找元素所在的集合
        3、合并：将两个元素所在的集合合并为一个集合

代码模板：
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}