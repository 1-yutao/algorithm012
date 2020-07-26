package org.millet.algorithm.week_03;

/**
 * 爬楼梯
 * 解题：
 *  1、递归
 *
 *
 * 题目：
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by yutao
 * Create date 2020/7/21 8:52
 */
public class ClimbStairs {

    /**
     * 动态规划
     * 基于 递推公式 F(n) = F(n - 1) + F(n - 2)
     * @param n
     * @return
     */
    public int climbStairs_03(int n) {
        if (n <= 0) return 0;
//        if (n == 1) return 1;
//        if (n == 2) return 2;
        int num = 1, n1 = 0, n2 = 0;
        for (int i = 1; i <= n; i++) {
            n1 = n2;
            n2 = num;
            num = n1 + n2;

        }
        return num;
    }

    /**
     * 记忆递归法
     *  将已计算的数据缓存下来
     * @param n
     * @return
     */
    public int climbStairs_02(int n) {
        if (n <= 0) return 0;
        int[] memo = new int[n + 1];   //保存已计算过的值
        return climbStairsMemo(n, memo);
    }

    private int climbStairsMemo(int n, int[] memo) {
        if (memo[n] > 0) return memo[n];
        if (n == 1) {
            memo[n] = 1;
        }
        else if (n == 2) {
            memo[n] = 2;
        }
        else {
            memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        }
        return memo[n];
    }


    /**
     * 递推公式 F(n) = F(n - 1) + F(n - 2)
     * @param n
     * @return
     */
    public int climbStairs_01(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs_01(n - 1) + climbStairs_01(n - 2);
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int result = climbStairs.climbStairs_03(3);
        System.out.println(result);
    }
}
