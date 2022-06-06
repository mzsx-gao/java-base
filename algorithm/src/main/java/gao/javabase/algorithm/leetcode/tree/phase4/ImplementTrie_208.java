package gao.javabase.algorithm.leetcode.tree.phase4;

/**
 * @author  gaosd
 * @description ：(LeetCode-208) 实现 Trie (前缀树)
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，
 * 用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 请你实现 Trie 类
 */
public class ImplementTrie_208 {

    /*树节点的定义*/
    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {
            /*word和prefix仅由小写英文字母组成，只有26种可能*/
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    static class Trie {
        /*Trie的根节点*/
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            insertChar(word, 0, root);
        }

        public boolean search(String word) {
            return searchChar(false,word,0, root);
        }

        public boolean startsWith(String prefix) {
            return searchChar(true,prefix,0, root);
        }

        /*用递归实现插入字符串*/
        void insertChar(String word, int index, TrieNode currNode) {
            /*字符串中的字符已经全部插入完成，增加结束标识*/
            if (index == word.length()) {
                currNode.isEnd = true;
                return;
            }
            /*计算字符在数组中的下标*/
            int charIndex = word.charAt(index) - 'a';
            if (currNode.children[charIndex] == null) {
                currNode.children[charIndex] = new TrieNode();
            }
            insertChar(word, index + 1, currNode.children[charIndex]);
        }

        /*用递归实现查找字符串，
        题目要求实现的search和startsWith本质上是一回事，所以共用一个查找方法
        用参数isPrefix区分*/
        boolean searchChar(boolean isPrefix,String word, int index, TrieNode currNode) {
            /*整个字符串遍历完成，要返回true，要么是前缀查找，要么达到了子树的最后*/
            if (index == word.length()) {
                return isPrefix || currNode.isEnd;
            }
            int charIndex = word.charAt(index) - 'a';
            if (currNode.children[charIndex] == null) {
                return false;
            }
            return searchChar(isPrefix,word, index + 1, currNode.children[charIndex]);
        }

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("markx");
        trie.insert("market");
        System.out.println(trie.startsWith("mar"));
    }


}
