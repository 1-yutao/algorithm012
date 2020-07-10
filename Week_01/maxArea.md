题目：盛水最多的容器
记录：
【On the first try】
    看到题目是一开始一脸懵逼，然后看了覃老师的讲解视频后，豁然开朗，先按这个思路自己写了一个,贴到力扣上执行成功。
【on the second try】
    脑子里冒出一个想法，设置两个指针 i j，分别取数组的头和尾的数据，在一个循环中 mod%2 == 0 ? i++ : j--
    于是乎写出了如下搓代码，第一次测试的用例数组是：[1,8,6,2,5,4,8,3,7]，结果是对的，欣喜，以为成功，然后贴到力扣
    执行失败！！原因是这样做会丢失部分柱子的组合机会
【on the third try】
    模仿最优解！
    看了最优解我突然好开心，跟我的第二次尝试思路很像，但不同之处是，我每次分别移动前后两个指针，最优解则是每次移动最短那边的指针，呜呼！豁然开朗！不禁感叹，真是失之毫厘谬以千里啊！果断不看最优解代码直接按照该思路改代码。
    成功提交到力扣！击败70.42%的人，哈哈

【on the fourth try】
    阅读最优解源码，比较与第三次代码，找出差距和优化点


代码：
On the first try

    /**
     * 设置两个loop，分别控制两根柱子，遍历出所有两根柱子的面积，取最大者
     *
     */
    public int maxArea(int[] height) {
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
//-----------------------------------------------------------------------------


on the second try
一次失败的尝试！！
原因：
    if (mod%2 == 0)
        i++;
    else
        j--;
在一个循环里每次只移动一个柱子，会丢失部分柱子的组合机会

    /**
     * 
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
//-----------------------------------------------------------------------------

on the thrid try!
模仿最优代码：
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

//-----------------------------------------------------------------------------

on the fourth try
    优化代码
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