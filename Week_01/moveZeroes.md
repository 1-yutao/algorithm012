题目：移动零
  记录：
    一读到这个题时，最先想到的方法是，定义一个记录最左侧0位置的指针（leftZeroIndx），然后下标指针(i)继续向后，
    遇到非0数字与num[leftZeroIndx]交换，并且把leftZeroIndx=i 结果失败了，这样只能移动一个0到末尾。
    看了最优题解后明白了，我的改动只需要把leftZeroIndx自增即可，不要置为i, 就像挤出泡沫一样。
    
  代码如下：
    错误代码：
    public void moveZeroes0(int[] nums) {
            int length;
            if (nums == null || (length = nums.length) == 0)
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
        
    读最优题解之后：
    public void moveZeroes(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0)
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
    
    改正错误代码：
    public void moveZeroes0(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0)
            return;

        int leftZeroIndx = -1;
        for (int i = 0; i < length; i++) {
            int n = nums[i];
            if(n == 0){
                leftZeroIndx = leftZeroIndx == -1 ? i : -1;
                continue;
            }
            
            nums[i] = nums[leftZeroIndx];
            nums[leftZeroIndx] = n;
            leftZeroIndx++;
        }
    }
    
    优化代码：
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