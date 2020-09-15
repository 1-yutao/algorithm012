package org.millet.algorithm.week_06;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 *
 * [
 *   [2],
 *   [3,4],
 *   [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）
 *
 * 相邻结点：与(i, j) 点相邻的结点为 (i + 1, j) 和 (i + 1, j + 1)。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Created by yutao
 * Create date 2020/8/25 17:14
 */
public class MinimumTotal {

    /**
     * 记忆递归法
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] memo = new Integer[triangle.size()][triangle.size()];

        return _dfs(triangle, memo, 0, 0);
    }

    private int _dfs(List<List<Integer>> triangle, Integer[][] memo, int i, int j) {
        if (i == triangle.size()) return 0;

        if (memo[i][j] != null) return memo[i][j];

        return memo[i][j] = Math.min(
          _dfs(triangle, memo, i + 1, j), _dfs(triangle, memo, i + 1, j + 1)
        ) + triangle.get(i).get(j);
    }

    /**
     * 动态规划
     *  定义dp二维数组，自底向上递归
     *  1、状态定义：
     *      dp[i][j] 表示从点 (i, j)到底边的最小路径和。
     * 2、状态转移：
     *      dp[i][j] =
     *          min(dp[i + 1][j], dp[i + 1][j + 1])
     *        +
     *          triangle[i][j]
     *
     * 作者：sweetiee
     * 链接：https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();

        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和
        int[][] dp = new int[n + 1][n + 1];

        // 从三角形的最后一行开始递推。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1])
                            + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
