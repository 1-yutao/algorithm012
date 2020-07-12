package org.millet.algorithm.week_01;

import java.util.Arrays;

/**
 * 旋转数组
 * 题目：https://leetcode-cn.com/problems/rotate-array/
 * 分析：1、原数组移动，空间复杂度O(1)，也就是不能new新数组
 *
 *  注意： k > length 时用copy法 需要 k = k - length
 *
 * Created by yutao
 * Create date 2020/7/11 17:07
 */
public class Rotate {

    public static void main(String[] args) {
        int[] nums = {1,2};
        int k = 3;
        rotate3(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 基于 rotate2的优化
     * 当 k > length时，只需要移动 k - length 位即可
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        if (nums == null || k < 0)
            return;
        int length = nums.length;
        if(length < 2)
            return;
        if (k > length) {
            k = k - length;
        }
        int[] new_nums = new int[length];
        System.arraycopy(nums, length - k, new_nums, 0, k);
        System.arraycopy(nums, 0, new_nums, k, length - k);
        for (int i = 0; i < length; i++) {
            nums[i] = new_nums[i];
        }
    }

    /**
     * new一个新数组，先把num[length - k]到数组末尾的数据复制到新数组，然后复制num[0] - num[length - k - 1]的数据
     * 不满足题目要求，new了新数组
     * bug： 当移动的次数 k > length的时候会报错
     *
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        if (nums == null || k < 0)
            return;
        int length = nums.length;
        if(length < 2)
            return;
        int[] new_nums = new int[length];
        System.arraycopy(nums, length - k, new_nums, 0, k);
        System.arraycopy(nums, 0, new_nums, k, length - k);
        for (int i = 0; i < length; i++) {
            nums[i] = new_nums[i];
        }
    }

    /**
     * 暴力求解
     * 旋转K次，每次旋转一个元素
     * 时间复杂度O(n*k)
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null || k < 0)
            return;
        int p, tmp;
        for(int i = 0; i < k; i++){
            p = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                tmp = nums[j];
                nums[j] = p;
                p = tmp;
            }
        }

    }

}
