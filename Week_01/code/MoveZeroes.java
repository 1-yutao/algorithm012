package org.millet.algorithm.week_01;

import java.util.Arrays;

/**
 * 移动零
 * Created by yutao
 * Create date 2020/7/8 18:19
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes0(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes3(int[] nums)  {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return;
        }

        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                if (i > j) {// #1   优秀的优化，避免了i j指向同一位置时的交换
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    private void moveZeroes2(int[] nums) {
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
//
//        作者：wang_ni_ma
//        链接：https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    }

    public void moveZeroes(int[] nums) {
        int length;
        if(nums == null || (length = nums.length) == 0)
            return;

        int leftZeroIndx = 0;
        for (int i = 0; i < length; i++) {
            int n = nums[i];
            if (n != 0) {
                nums[i] = nums[leftZeroIndx];
                nums[leftZeroIndx++] = n;
            }
        }
    }


    public void moveZeroes0(int[] nums) {
        int length;
        if(nums == null || (length = nums.length) == 0)
            return;

        int leftZeroIndx = -1;
        for (int i = 0; i < length; i++) {
            int n = nums[i];
            if(n == 0 && leftZeroIndx == -1){
                leftZeroIndx = i;
                continue;
            }
            
            nums[i] = nums[leftZeroIndx];
            nums[leftZeroIndx] = n;
            leftZeroIndx++;
        }
    }


}
