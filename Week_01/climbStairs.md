题目：爬楼梯
记录：
    一看题目完全懵逼！
    总结覃老师视频中的讲解：先枚举出一些简单情况，找出最近重复子问题
    通过枚举的方式能发现是斐波那契数列，但公式怎么推导出来的没理解，暂时先记下来，后续再去理解吧


on the frist try 
斐波那契数列
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        //斐波那契数列的公式 F(n) = F(n - 1) + F(n - 2)
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

提交到力扣结果：超出时间限制
//-----------------------------------------------------------------------------

on the second try
循环n次 累加结果
    public int climbStairs2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int F = 0, F1 = 1, F2 = 2;
        for(int i = 3; i <= n; ++i ){
            F = F1 + F2;
            F1 = F2;
            F2 = F;
        }
        return F;
    }

提交到力扣结果：成功

