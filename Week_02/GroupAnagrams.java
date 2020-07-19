package org.millet.algorithm.week_02;

import java.util.*;

/**
 * 字母异位词分组
 * 题目：给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * --------------------------------------
 *
 * 解题思路
 * 方法一：Hash法
 *      设置一个HashMap, key是排序后的字符串，value 与key匹配的异位词的ArrayList
 *
 *
 * Created by yutao
 * Create date 2020/7/17 9:49
 */
public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        GroupAnagrams g = new GroupAnagrams();
        List<List<String>> resultList = g.groupAnagrams3(strs);
        System.out.println(Arrays.toString(resultList.toArray()));
    }

    /**
     * 对groupAnagrams2的再优化
     * 用空间换时间：put到Map中的List<String>引用, add到List<List<String>>中，循环结束返回
     *   省去 groupAnagrams2 中末尾的 new ArrayList<>(groupMap.values())
     *
     *   LeetCode中比groupAnagrams2 快了 1ms
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams3(String[] strs) {
        int length;
        if (strs == null || (length = strs.length) == 0) return null;

        List<List<String>> resultList = new ArrayList<>();
        Map<String, List<String>> groupMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String s = strs[i];
            char[] sort = s.toCharArray();
            Arrays.sort(sort);
            String key = new String(sort);
            List<String> list = groupMap.get(key);
            if (list == null) {
                list = new ArrayList<>();
                list.add(s);

                resultList.add(list);
                groupMap.put(key, list);
            } else {
                list.add(s);
            }
        }

        return resultList;
    }

    /**
     * 对groupAnagrams的优化
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        int length;
        if (strs == null || (length = strs.length) == 0) return null;

        Map<String, List<String>> groupMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String s = strs[i];
            char[] sort = s.toCharArray();
            Arrays.sort(sort);
            String key = new String(sort);
            List<String> list = groupMap.get(key);
            if (list == null) {
                list = new ArrayList<>();
                list.add(s);
                groupMap.put(key, list);
            } else {
                list.add(s);
            }
        }

//        List<List<String>> resultList = new ArrayList<>(groupMap.size());
//        Set<Map.Entry<String, List<String>>> set = groupMap.entrySet();
//        Iterator<Map.Entry<String, List<String>>> it = set.iterator();
//        while (it.hasNext()) {
//            Map.Entry<String, List<String>> entry = it.next();
//            resultList.add(entry.getValue());
//        }
        return new ArrayList<>(groupMap.values());
    }

    /**
     * 方法一：Hash法
     *    设置一个HashMap, key是排序后的字符串，value 与key匹配的异位词的ArrayList
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        int length;
        if (strs == null || (length = strs.length) == 0) return null;

        Map<String, List<String>> groupMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String s = strs[i];
            char[] sort = s.toCharArray();
            Arrays.sort(sort);
            String key = new String(sort);
            List<String> list = groupMap.get(key);
            if (list == null) {
                list = new ArrayList<>();
                list.add(s);
                groupMap.put(key, list);
            } else {
                list.add(s);
            }
        }

        List<List<String>> resultList = new ArrayList<>(groupMap.size());
        Set<Map.Entry<String, List<String>>> set = groupMap.entrySet();
        Iterator<Map.Entry<String, List<String>>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<String>> entry = it.next();
            resultList.add(entry.getValue());
        }
        return resultList;
    }
}
