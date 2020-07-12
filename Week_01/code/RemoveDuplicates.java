package org.millet.algorithm.week_01;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 * 题目：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * 题目分析：
 * 1、数组已排序
 * 2、在原数组上删除，不能new新数组
 * 3、在使用O(1)的空间复杂度
 * 4、只调整原数组中重复数据的位置，不实际删除
 *
 * 思路：
 *   没想出，直接看了题解，明白后动手干，没有抄最优解的源码
 * Created by yutao
 * Create date 2020/7/11 16:14
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int l = removeDuplicates(nums);
        System.out.println(l);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        //题解中的思路：数组是排过序的，也就是相同的数字肯定挨在一起
        //设置两个指针，i,j num[i] == num[j]时 i不动，j++; 不同时i++ j++; 知道j == length - 1

        if (nums == null) {
            return 0;
        }

        int i = 0, j = 0;
        while (j < nums.length){
            if (nums[i] == nums[j]) {
                j++;
            } else {
                int tmp = nums[i + 1];
                nums[i + 1] = nums[j];
                nums[j] = tmp;
                i++;
                j++;
            }
        }
        return i + 1;
    }
}
