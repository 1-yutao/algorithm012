package org.millet.algorithm.week_09;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * Created by yutao
 * Create date 2020/9/3 20:45
 */
public class ReverseWords3 {

    public static String reverseWords(String s) {
        if (s == null || "".equals(s)) return "";

        int spaceIndex = -1;
        int start = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ' && i < chars.length - 1)
                continue;
            spaceIndex = i == chars.length - 1 ? i : i -1;
            while (start < spaceIndex){
                char tmp = chars[spaceIndex];
                chars[spaceIndex] = chars[start];
                chars[start] = tmp;

                start++;
                spaceIndex--;
            }
            start = i + 1;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
