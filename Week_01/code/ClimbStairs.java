package org.millet.algorithm.week_01;

/**
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 * Created by yutao
 * Create date 2020/7/9 18:07
 */
public class ClimbStairs {

    public static void main(String[] args) {

        int n = 6;
        ClimbStairs climbStairs = new ClimbStairs();
        int result = climbStairs.climbStairs2(n);
        System.out.println(result);
    }

    public int climbStairs2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int F = 0, F1 = 1, F2 = 2;
        for(int i = 3; i <= n; ++i ){
            F = F1 + F2;
            F1 = F2;
            F2 = F;
        }
        return F;
    }

    /**
     * 斐波那契数列 实现
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        //斐波那契数列的公式 F(n) = F(n - 1) + F(n - 2)
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

}
