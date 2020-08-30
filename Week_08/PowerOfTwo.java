package org.millet.algorithm.week_08;

/**
 *
 * 231. 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 * Created by yutao
 * Create date 2020/8/27 9:58
 */
public class PowerOfTwo {

    /**
     * 该写法提交力扣是错误
     * 原因：未考虑负数情况
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count == 1;
    }

    /**
     * 最优
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        return n != 0 && (n & (n - 1)) == 0;
    }
}
