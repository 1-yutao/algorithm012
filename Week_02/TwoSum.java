package org.millet.algorithm.week_02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 题目：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *         你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 题解：1、题目中说找出和为目标值的【两个】整数，也就是遇到就返回这两个整数的下标，不必找出全部
 * 2、用hash法，遍历一次数组，int diff = target - num[i];
 *     if (map.get(diff) == null) map.put(diff, i);
 *     else return map.get(diff)和 i
 * Created by yutao
 * Create date 2020/7/17 8:29
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 4, 9};
        int target = 9;
        int[] result = twoSum.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {
        int length;
        if (nums == null || (length = nums.length)  == 0) return nums;

        //大数据量且明确数据数量时，未防止HashMap动态扩容带来的性能开销,
        //  阿里的开发规范中规定：int initialCapacity = (需要存储的元素个数/负载因子) + 1；
        //  负载因子用默认的0.75
        //此处使用仅加深记忆尔
        int size = (int) ((length - 1)/0.75f + 1);
        Map<Integer, Integer> indexMap = new HashMap<>(size);
        for (int i = 0; i < length; i++) {
            int n = target - nums[i];
            Integer index = indexMap.get(n);
            if (index != null)
                return new int[]{index, i};
            else
                indexMap.put(nums[i], i);

        }
        return new int[0];
    }

}
