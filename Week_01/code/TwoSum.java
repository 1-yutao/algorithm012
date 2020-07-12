package org.millet.algorithm.week_01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 思路
 *  1、hash法
 *  2、双指针法
 *
 *
 *  题目：
 *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * --------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by yutao
 * Create date 2020/7/11 14:32
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,4};
        Arrays.sort(nums);
        int[] result = twoSum2(nums, 6);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum2(int[] nums, int target) {
        //双hash 法
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        int[] resp = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            Integer exist = hashMap.get(diff);
            if(hashMap.containsKey(diff) && hashMap.get(diff) != i){
                return new int[] { i, hashMap.get(diff) };
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[0];

    }

    /**
     * hash 法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        //hash 法
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] resp = new int[2];
        Map<Integer, Integer> hashMap = new HashMap<>(nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            Integer exist = hashMap.get(diff);
            if(exist != null){
                resp[0] = exist;
                resp[1] = i;
                return resp;
            } else {
              hashMap.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
