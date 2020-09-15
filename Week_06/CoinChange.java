package org.millet.algorithm.week_06;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 力扣：https://leetcode-cn.com/problems/coin-change/description/
 * Created by yutao
 * Create date 2020/8/26 9:30
 */
public class CoinChange {

    int[] memo;
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;

        memo = new int[amount + 1];

        return findWay(coins, amount);
    }

    /**
     * memo[amount] 表示amount最少能换取的硬币数，不能换就是-1；
     * findWay函数的目的是找出amount数量的零钱可以兑换的最少硬币数量，返回其值 int
     * @param coins
     * @param amount
     * @return
     */
    private int findWay(int[] coins, int amount) {
        if (amount < 0) return -1;

        if (amount == 0) return 0;

        if (memo[amount] != 0) return memo[amount];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = findWay(coins, amount - coin);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        memo[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        CoinChange coinChange = new CoinChange();
        int result = coinChange.coinChange(coins, amount);
        System.out.println(result);
    }

}
