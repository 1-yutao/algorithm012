package org.millet.algorithm.week_08;

import java.util.Arrays;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 *
 * Created by yutao
 * Create date 2020/8/30 15:56
 */
public class Merge {

    /**
     * 题解来源： https://leetcode-cn.com/problems/merge-intervals/solution/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 先按区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        //遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] ints : intervals) {
            //如果结果数组是空的，或者当前数组的起始位置 > 结果数组中最后区间的终止位置
            //则不合并，直接将当前区间加入到结果数组
            if (idx == -1 || ints[0] > res[idx][1]) {
                res[++idx] = ints;
            } else {
                //反之，将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], ints[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};

        Merge merge = new Merge();
        int[][] result = merge.merge(arr);
        for (int[] a : result)
            System.out.println(Arrays.toString(a));
    }
}
