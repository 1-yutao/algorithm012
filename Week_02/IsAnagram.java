package org.millet.algorithm.week_02;

import java.util.Arrays;

/**
 * 有效的字母异位
 * 题目：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 *      例如：输入: s = "anagram", t = "nagaram"
 *           输出: true
 *
 *           输入: s = "rat", t = "car"
 *           输出: false
 *    说明：你可以假设字符串只包含小写字母。
 *    进阶:
 *      如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 *  解题思路：
 *   所谓异位词，意思是说，两个字符串包含的字母一样，只是顺序不同
 *  方法一：
 *      对两个字符串排序，然后equals比较其内容是否相同
 * 方法二：
 *  哈希表
     * 算法：
     * 为了检查 tt 是否是 ss 的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。
 *      因为 SS 和 TT 都只包含 A-ZA−Z 的字母，所以一个简单的 26 位计数器表就足够了。
     * 我们需要两个计数器数表进行比较吗？实际上不是，因为我们可以用一个计数器表计算 ss 字母的频率，用 tt 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * Created by yutao
 * Create date 2020/7/16 12:18
 */
public class IsAnagram {

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        String s = "abcddddddddddddd";
        String t = "bcaddddddddddddd";

        long count = 10000000;

        long st1 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            boolean result = isAnagram.isAnagram3(s, t);
        }
        long et1 = System.currentTimeMillis();
        System.out.println("减法时间：" + (et1 - st1));

        long st2 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            boolean result = isAnagram.isAnagram2(s, t);
        }
        long et2 = System.currentTimeMillis();
        System.out.println("取模时间：" + (et2 - st2));
    }

    /**
     * 解题思路类似isAnagram2 只是在计算hash表下标时由取模改为了减法
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram3(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 97]++;
            count[t.charAt(i) - 97]--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    /**
     * 哈希法
     * 根据题意，入参都是由字母组成的字符串; 设置一个hash表保存各字母出现的次数，遍历s数组时，在hash表中+1；
     *  遍历t表时在hash表中-1, 最后遍历hash表，其中有大于0的字母返回false
     *
     *  建立hash数组时，计算下标指针的方式是 s.charAt(i)%26
     *  取模运算速度比较慢，改为 s.charAt(i) - 'a'
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)%26]++;
            count[t.charAt(i)%26]--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    /**
     * 排序两个字符串，然后比较是否相同
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return  false;
        if(s.length() != t.length()) return false;

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        Arrays.sort(sc);
        Arrays.sort(tc);

        return Arrays.equals(sc, tc);
    }
}
