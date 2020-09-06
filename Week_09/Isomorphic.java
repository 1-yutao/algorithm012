package org.millet.algorithm.week_09;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * Created by yutao
 * Create date 2020/9/3 21:28
 */
public class Isomorphic {

    /**
     * 此题的关键之处在于，s --> t 成立，也必须 t -- s 也成立
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        if (s.length() == 0) return true;

        return _isIsomorphic(s, t) && _isIsomorphic(t, s);
    }

    private  boolean _isIsomorphic(String s, String t) {
        Map<Character, Character> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = hashMap.get(s.charAt(i));
            if (ch == null) {
                hashMap.put(s.charAt(i), t.charAt(i));
            } else if (ch != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Isomorphic isomorphic = new Isomorphic();
        System.out.println(isomorphic.isIsomorphic("ab", "aa"));
    }
}
