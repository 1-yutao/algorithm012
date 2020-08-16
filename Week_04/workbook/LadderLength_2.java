/**
 * 默写【单词接龙】 第二遍
 * 
 *  思路：无向图，需要记录已访问过的数据
 * 
 * 题目：https://leetcode-cn.com/problems/word-ladder/description/
 */

 /**
  * 广度优先算法
  */
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //先将wordList放入哈希表中，便于某个单词是否在wordList中
    Set<String> wordSet = new HashSet<>(wordList);
    if (wordList.size() == 0 || !wordSet.contains(endWord))
        return 0;

    wordSet.remove(beginWord);

    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);

    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    int step = 1;

    while (!queue.isEmpty()) {
        int currSize = queue.size();
        while (currSize --> 0) {    //依次遍历当前队列中所有元素
            String word = queue.poll();
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char originChar = charArray[i];
                for (char c = 'a'; c <= 'z'; c++) { //循环替换每一个小写英文字母
                    charArray[i] = c;
                    String newWord = new String(charArray);

                    if (wordSet.contains(newWord)) {
                        if (newWord.equals(endWord)) {
                            return step + 1;
                        }

                        if (!visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
                charArray[i] = originChar;  //还原
            }
        }
        step++; //每循环一次队列，步骤+1
    }
    return 0;
}