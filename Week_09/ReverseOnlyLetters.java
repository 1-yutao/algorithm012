package org.millet.algorithm.week_09;

/**
 * Created by yutao
 * Create date 2020/9/3 21:10
 */
public class ReverseOnlyLetters {

    public static String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) return "";

        char[] chars = S.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (!Character.isLetter(chars[start])){
                start++;
                continue;
            }
            if (!Character.isLetter(chars[end])) {
                end--;
                continue;
            }
            char temp = chars[end];
            chars[end] = chars[start];
            chars[start] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}
