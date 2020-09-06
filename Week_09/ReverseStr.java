package org.millet.algorithm.week_09;

/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 * Created by yutao
 * Create date 2020/9/3 19:56
 */
public class ReverseStr {

    /**
     * 把数据 每2k个分隔为快，其中前k个翻转
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 ) return "";

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i = i + 2*k) {
            int start = i;
            int end = Math.min(i + k -1, chars.length - 1);

            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;

                start++;
                end--;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefghigklmnopqrst", 3));
    }
}
