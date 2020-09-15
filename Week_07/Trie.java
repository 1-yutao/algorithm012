package org.millet.algorithm.week_07.homework;

/**
 * 前缀树
 *  发音同 try ，是一种树数据结构，用于检索字符串数据集中的键，这种高级的应用有多钟应用
 *  1、自动补全
 *  2、拼写检查
 *  3、IP路由（最长前缀匹配）
 *  4、T9 (9宫格打字预测）
 *  5、单词游戏
 *  6、
 * Created by yutao
 * Create date 2020/8/20 21:39
 */
public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || "".equals(word)) return;

        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        return false;
    }

    class TrieNode {
        private boolean isEnd;
        TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }
}
