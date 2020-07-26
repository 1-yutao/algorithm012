package org.millet.algorithm.week_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yutao
 * Create date 2020/7/21 17:25
 */
public class GenerateParenthesis {

    /**
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return Collections.emptyList();
        List<String> resultList = new ArrayList<>();
        _generater(0, 0, n, "", resultList);
        return resultList;
    }

    /**
     * 左右括号都不能超过 n 个
     * @param left
     * @param right
     * @param n
     * @param s
     * @param resultList
     */
    private void _generater(int left, int right, int n, String s, List<String> resultList) {
        //terminator
        if (left == n && right == n) {
            resultList.add(s);
            return;
        }
        //process current logic: left , right;

        //drill down
        if ( left < n)
            _generater(left + 1, right, n, s + "(", resultList);

        if (right < left)
            _generater(left, right + 1, n, s + ")", resultList);
    }


    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> resultList = generateParenthesis.generateParenthesis(3);
        System.out.println(Arrays.toString(resultList.toArray()));
    }
}
