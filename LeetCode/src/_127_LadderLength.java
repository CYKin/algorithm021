import java.util.*;

/**
 * @ClassName: _127_LadderLength
 * @Description: 127. 单词接龙
 * @Author: wangchangyong
 * @Date: 2021/1/16 17:22
 * @Version: 1.0.0
 **/
public class _127_LadderLength {

    /**
     * 双向BFS
     * 时间复杂度：
     * 空间复杂度：
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int step = 1;
        HashSet<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // 双向交替搜索
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                // 替换一个字符搜索
                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (wordSet.contains(target)) {
                            // target在endSet中 双向搜索相交
                            if (endSet.contains(target)) {
                                return step + 1;
                            }
                            if (!visited.contains(target)) {
                                temp.add(target);
                                visited.add(target);
                            }
                        }
                    }
                    chs[i] = old;
                }
            }
            // 搜索结果赋值 进行下一轮搜索
            beginSet = temp;
            step++;
        }
        return 0;
    }

    /**
     * 广度优先搜索
     * 时间复杂度：
     * 空间复杂度：
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }

        int step = 1;

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                char[] currArray = curr.toCharArray();
                for (int j = 0; j < currArray.length; j++) {
                    char old = currArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) {
                            continue;
                        }
                        currArray[j] = c;
                        String nextWord = new String(currArray);
                        if (wordSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(nextWord)) {
                                visited.add(nextWord);
                                queue.offer(nextWord);
                            }
                        }
                    }
                    currArray[j] = old;
                }
            }
            step++;
        }
        return 0;
    }
}
