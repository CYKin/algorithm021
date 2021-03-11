import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _212_FindWords
 * @Description: 212. 单词搜索 II
 * @Author: wangchangyong
 * @Date: 2021/2/4 21:23
 * @Version: 1.0.0
 **/
public class _212_FindWords {

    /**
     * 字典树 + 递归/dfs/分治/回溯
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(k)
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        // 构造单词字段树
        TrieNode trie = buildTrie(words);
        // 回溯搜索单词
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie, result);
            }
        }
        return result;
    }

    /**
     * 递归/dfs/分治/回溯
     * @param board
     * @param i
     * @param j
     * @param trie
     * @param result
     */
    public void dfs(char[][] board, int i, int j, TrieNode trie, List<String> result) {
        // 开始搜索字符
        char c = board[i][j];
        // 字符是否是某一个单词
        if (c == '*' || trie.children[c - 'a'] == null) {
            return;
        }
        TrieNode curNode = trie.children[c - 'a'];
        // 是否是单词
        if (curNode.word != null) {
            result.add(curNode.word);
            curNode.word = null;
        }

        // 出现过一次后置*
        board[i][j] = '*';

        // 分治 水平和垂直向下搜索
        if (i - 1 >= 0) {
            dfs(board, i - 1, j, curNode, result);
        }
        if (i + 1 < board.length) {
            dfs(board, i + 1, j, curNode, result);
        }
        if (j - 1 >= 0) {
            dfs(board, i, j - 1, curNode, result);
        }
        if (j + 1 < board[i].length) {
            dfs(board, i, j + 1, curNode, result);
        }

        // 本层更改数据还原
        board[i][j] = c;
    }

    /**
     * 将单词构建成一颗字典树
     * @param words
     * @return
     */
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode trie = root;
            char[] wordArray = word.toCharArray();
            for (char c : wordArray) {
                if (trie.children[c - 'a'] == null) {
                    trie.children[c - 'a'] = new TrieNode();
                }
                trie = trie.children[c - 'a'];
            }
            trie.word = word;
        }
        return root;
    }

    /**
     * 字典树
     */
    class TrieNode {
        public String word;
        public TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }
    }
}
