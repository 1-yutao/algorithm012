package org.millet.algorithm.week_08;

/**
 * 约瑟夫环
 *  定义：N个人围成一个圈，第一个人从1开始报数，报到M的人被杀，下一个人继续从1开始报数，循环往复，直到剩下最后一个人
 *  递推公式：f(n, m) = (f(n - 1, m) + m) % n
 * Created by yutao
 * Create date 2020/8/28 7:45
 */
public class Joseph {

    /**
     * M 不能是 1 ，不然没有幸存者
     * @param n
     * @param m
     * @return
     */
    public int cir(int n, int m) {
        int p = 0;

        for (int i = 2; i <= n; i++) {      //注意 i 是从2开始的
            p = (p + m) % i;
        }
        return p + 1;
    }

    public static void main(String[] args) {
        Joseph joseph = new Joseph();
        int result = joseph.cir(10, 3);
        System.out.println(result);
    }
}
