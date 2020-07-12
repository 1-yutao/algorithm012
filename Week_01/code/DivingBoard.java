package org.millet.algorithm.week_01;

import java.util.Arrays;

/**
 * 跳水板问题
 * Created by yutao
 * Create date 2020/7/8 13:26
 */
public class DivingBoard {

    public static void main(String[] args) {

        int shorter = 1;    //短木板
        int longer = 3;     //长木板
        int k = 3;          //木板数
        int[] result = divingBoard(shorter,  longer, k);

        System.out.println(Arrays.toString(result));
    }

    private static int[] divingBoard(int shorter, int longer, int k) {
        //1、shorter == longer  shorter*k
        //2、当 shorter < longer 时
        ///首先用k块shorter拼接出最短的木板
        ///然后从第一块开始替换shorter,直到最后一块
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter*k};
        }

        int[] lenghts = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            lenghts[i] = shorter * (k - i) + longer * i;
        }
        return lenghts;

    }


}
