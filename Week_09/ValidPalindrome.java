package org.millet.algorithm.week_09;

/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * Created by yutao
 * Create date 2020/9/3 22:12
 */
public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        //定义两个指针，分别从两头向里走，遇到不同，或左++ 或右-- , 逻辑或二者的结果
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j])
                return _palindrome(chars, i + 1, j) || _palindrome(chars, i, j - 1);
        }
        return true;
    }

    private boolean _palindrome(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i++] != chars[j--])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.validPalindrome("abdda"));
    }
}
