package org.millet.algorithm.week_01;

import java.util.*;

/**
 * Created by yutao
 * Create date 2020/7/10 17:50
 */
public class ThreeSum {

    public static void main(String[] args) {

        int[] nums =
                //{};
                {-1, 0, 1, 2, -1, -4};

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> respList = threeSum.threeSum3(nums);

        System.out.println(Arrays.toString(respList.toArray()));

    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }
//
//    作者：guanpengchn
//    链接：https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * hash
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        if(nums == null || nums.length < 2)
            return new ArrayList<>();
        Arrays.sort(nums);


        Set<List<Integer>> respSet = new LinkedHashSet<>();
        int length = nums.length;
        for(int i = 0; i < length - 2; i++){
            int target = -nums[i];
            Map<Integer, Integer> hashMap = new HashMap<>(length - i);
            for(int j = i + 1; j < length; j++){
                int v = target - nums[j];
                Integer exist = hashMap.get(v);
                if(exist != null){
                    List<Integer> list = Arrays.asList(nums[i], nums[j], exist);
                    list.sort(Comparator.naturalOrder());
                    respSet.add(list);
                }else {
                    hashMap.put(nums[j], nums[j]);
                }
            }
        }
        return new ArrayList<>(respSet);
    }
    /**
     * 排序+三重循环
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 2)
            return new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> respSet = new LinkedHashSet<>();
        int length = nums.length;
        for(int i = 0; i < length - 2; i++){
            for(int j = i + 1; j < length - 1; j++){
                for(int k = j + 1; k < length; k ++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        List<Integer> l = Arrays.asList(nums[i], nums[j], nums[k]);
                        respSet.add(l);
                    }
                }
            }
        }
        return new ArrayList<>(respSet);
    }
}
