package org.millet.algorithm.week_09;

/**
 * 771. 宝石与石头
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * Created by yutao
 * Create date 2020/9/1 9:24
 */
public class NumJewelsInStones {

    public int numJewelsInStones(String J, String S) {
        if (J == null || "".equals(J)) return 0;
        if (S == null || "".equals(S)) return 0;

        char[] chars = new char[125];
        for (int i = 0; i < J.length(); i++) {
            chars[J.charAt(i)] = 1;
        }

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (chars[S.charAt(i)] > 0) count++;
        }
        return count;
    }

}
