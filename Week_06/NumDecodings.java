package org.millet.algorithm.week_06;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * Created by yutao
 * Create date 2020/9/14 21:40
 */
public class NumDecodings {

    /**
     * 非常类似于斐波那契数列（dp[i] = dp[i - 1] + dp[i -2]）, 但是需要有些条件下不能加
     *   1、第 i 位数与第 i - 1 位数组成的两数没有落在 10 - 26之间，那么dp[i - 2]就不能加。
     *   2、如果第 i 位的元素为 0 ，则不能加 dp[i - 1]
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == 0) return 0;
        if (s.length() == 1) return 1;

        int dp1 = 1;    //相当于dp[i - 2]
        int dp2 = 1;    //相当于dp[i - 1]
        int result = 0;

        for (int i = 1; i < s.length(); i++) {
            int n = (s.charAt(i - 1) - 48) * 10 + (s.charAt(i) - 48);
            //不能连续出现 0
            if (n == 0) return 0;

            //落在 10 到 26之间
            if (n >= 10 && n <= 26) {
                result = dp1;
            }

            if (s.charAt(i) != '0') {
                result += dp2;
            }
            dp1 = dp2;
            dp2 = result;
            result = 0;
        }

        return dp2;
    }

}
