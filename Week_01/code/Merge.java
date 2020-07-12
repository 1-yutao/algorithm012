package org.millet.algorithm.week_01;

import java.util.Arrays;

/**
 * 合并两个有序数组，将 b 数组合并到 a
 * Created by yutao
 * Create date 2020/7/12 15:42
 */
public class Merge {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0};
        int m = 3;
        int[] nums2 = {4,5};
        int n = 2;
        merge(nums1, m , nums2, n);
        System.out.println(Arrays.toString(nums1));
    }


    /**
     * 将 num2追加到nums1，然后排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null)
            return;
        for (int i = 0; i < n; i++) {
            nums1[m++] = nums2[i];
        }
        Arrays.sort(nums1);
    }

}
