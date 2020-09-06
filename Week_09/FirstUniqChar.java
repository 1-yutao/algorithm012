package org.millet.algorithm.week_09;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by yutao
 * Create date 2020/9/1 9:49
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        if (s == null || "".equals(s)) return -1;

        Map<Character, Integer> hashMap = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            hashMap.put(chars[i], hashMap.getOrDefault(chars[i], 0) + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            if (hashMap.get(chars[i]) != null && hashMap.get(chars[i]) == 1)    return i;
        }
        return -1;
    }

}
