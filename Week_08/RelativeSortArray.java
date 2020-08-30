package org.millet.algorithm.week_08;

/**
 * Created by yutao
 * Create date 2020/8/30 14:35
 */

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];

        for (int num1 : arr1) {
            count[num1]++;
        }
        int i = 0;
        for (int num2 : arr2) { //优先安排 arr2中的数
            while (count[num2] > 0) {
                arr1[i++] = num2;
                count[num2]--;
            }
        }

        for (int c = 0; c < count.length; c++) {
            while (count[c] > 0) {
                arr1[i++] = c;
                count[c]--;
            }
        }
        return arr1;
    }
}
