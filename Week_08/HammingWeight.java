package org.millet.algorithm.week_08;

/**
 * 191. 位1的个数
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * Created by yutao
 * Create date 2020/8/27 9:06
 */
public class HammingWeight {

    /**
     * 位移法
     *  将n 和 1 做 & 操作，结果是 1 则计数
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        if (n == 0) return 0;

        int count = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) == 1){
                count++;
            }
            n = n >> 1;     //此处可改为将mask左移一位，效果亦同
        }
        return count;
    }

    /**
     *  减 1 法
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        int result = hammingWeight.hammingWeight2(4);
        System.out.println(result);
    }

}
