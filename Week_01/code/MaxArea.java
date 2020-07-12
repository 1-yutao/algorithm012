package org.millet.algorithm.week_01;

/**
 * 盛水最多的容器
 * Created by yutao
 * Create date 2020/7/9 15:21
 */
public class MaxArea {

    public static void main(String[] args) {

        //int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {1,2,4,3};
        int maxArea = maxArea3(height);
        System.out.println(maxArea);
    }

    /**
     * 优化maxArea3的代码
     * @param height
     * @return
     */
    public static int maxArea4(int[] height) {
        int length;
        if (height == null || (length = height.length) == 0)
            return 0;

        int maxArea = 0;
        int i = 0, j = length - 1;
        while ( i != j ){

            int ai = height[i];
            int aj = height[j];
            //int heightDiff = Math.min(ai, aj);    //只用一次，没必要定义变量
            int area = (j - i) * Math.min(ai, aj);
            maxArea = Math.max(maxArea, area);

            if (ai < aj)
                i++;
            else
                j--;
        }

        return maxArea;
    }

    /**
     * 设置两个指针，分别取数组头和尾的数据
     * 每次移动数据最小一边的指针
     * @param height
     * @return
     */
    public static int maxArea3(int[] height) {
        int length;
        if (height == null || (length = height.length) == 0)
            return 0;

        int maxArea = 0;
        int i = 0, j = length - 1;
        while ( i != j ){

            int ai = height[i];
            int aj = height[j];
            int heightDiff = Math.min(ai, aj);
            int area = (j - i) * heightDiff;
            maxArea = Math.max(maxArea, area);

            if (ai < aj)
                i++;
            else
                j--;
        }

        return maxArea;
    }

    /**
     * 要想取得最大面积，必然是两个柱子最高且距离最远的
     * 设置两个指针 i j,分别从数组的两头开始往中间走，相遇为止，计算出最大面积
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int length;
        if (height == null || (length = height.length) == 0)
            return 0;

        int maxArea = 0;
        int mod = -1;
        int i = 0, j = length - 1;
        while ( (mod = (i + j)) <= length && i != j ){

            int ai = height[i];
            int aj = height[j];
            int heightDiff = Math.min(ai, aj);
            int area = (j - i) * heightDiff;
            maxArea = Math.max(maxArea, area);

            if (mod%2 == 0)
                i++;
            else
                j--;
        }

        return maxArea;
    }

    /**
     * 设置两个loop，分别控制两根柱子，遍历出所有两根柱子的面积，取最大者
     *
     */
    public static int maxArea(int[] height) {
        int length;
        if (height == null || (length = height.length) == 0)
            return 0;

        int maxArea = 0;
        for (int i = 0; i < length -1; i++) {
            int ai = height[i];
            for (int j = i + 1; j < length; j++) {
                int aj = height[j];
                int heightDiff = Math.min(ai, aj);
                int area = (j - i) * heightDiff;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
