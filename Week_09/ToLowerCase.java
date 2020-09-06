package org.millet.algorithm.week_09;

/**
 * 709. 转换成小写字母
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "Hello"
 * 输出: "hello"
 * 示例 2：
 *
 * 输入: "here"
 * 输出: "here"
 * 示例 3：
 *
 * 输入: "LOVELY"
 * 输出: "lovely"
 * Created by yutao
 * Create date 2020/9/1 8:52
 */
public class ToLowerCase {

    /**
     * 大写字母的ascII码是从 A 65开始的, 小写字母 a 是 97
     *  'a' - 'A' = 32
     * @param str
     * @return
     */
    public static String toLowerCase(String str) {
        if (str == null || "".equals(str)) return str;

        char[] chars = str.toCharArray();
        for (char i = 0; i < chars.length; i++) {
            if (65 <= chars[i] && chars[i] <= 91) {   //落在大写字母区间
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("Abc"));
    }
}
