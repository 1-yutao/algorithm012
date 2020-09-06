package org.millet.algorithm.week_09;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * Created by yutao
 * Create date 2020/9/1 18:54
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        StringBuilder sb = new StringBuilder();

        boolean init = false;
        int minLen = Integer.MAX_VALUE;
        int i = 0;
        while (i <= minLen) {
            char temp = Character.MAX_VALUE;
            boolean alike = true;
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() == 0) {
                    alike = false;
                    i = minLen + 1;
                    break;
                }
                if (!init)
                    minLen = Math.min(strs[j].length(), minLen);
                if (j ==0){
                    temp = strs[j].charAt(i);
                }else {
                    if (temp != strs[j].charAt(i)) {
                        alike = false;
                        i = minLen;
                        break;
                    }
                }
            }
            if (alike) {
                sb.append(strs[0].charAt(i));
            }
            init = true;

            i++;
        }
        return sb.toString();
    }

}
