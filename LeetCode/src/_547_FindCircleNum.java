/**
 * @ClassName: _547_FindCircleNum
 * @Description: 547. 省份数量
 * @Author: wangchangyong
 * @Date: 2021/1/12 21:43
 * @Version: 1.0.0
 **/
public class _547_FindCircleNum {

    /**
     * 并查集
     * 时间复杂度：O(n*n)
     * 空间复杂度：O(n)
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }

    class UnionFind {
        private int count = 0;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}
