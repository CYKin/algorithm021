## 学习笔记
## 字典树和并查集

### 字典树 Trie

- 字典树，即Tire树，又称单词查找树或键树，是一种树形结构。

- 优点是：最大限度地减少无畏的字符串比较，查询效率比哈希表高

- 性质：

  ​	- 结点本身不存完整单词

  ​	- 从根结点到某一点，路径上经过的字符连接起来，为该节点对应的字符串

  ​	- 每个节点的所有子节点路劲代表的字符串都不相同

- 核心思想：

  ​	- 空间换时间

  ​	- 利用字符串的公共前缀来降低查询时间的开销已达到提高效率的目的

- Java代码模板

```java
class Trie {

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
  
    public void insert(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode();
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode ws = root; 
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) {
              	return false;
            }
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode ws = root; 
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}

class TrieNode {
    public boolean isWord; 
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
}
```

### 并查集 Disjoint Set

- 适用场景：组团、配对问题

- 基本操作：

  ​	- makeSet(s)：建立一个新的并查集，其中包含s个单元数集合

  ​	- unionSet(x,y)：把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并

  ​	- find(x)：找到元素x所在的集合的代表，可以用于判断两个元素是否位于同一个集合，各自代表是否相等

- Java代码模板

```java
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
}
```

## 14、高级搜索

### 剪枝

- 去重复
- 搜索过程中移除决策树中分辨能力较弱的部分而减少树大小的方法，降低复杂度

### 双向 Breadth First Search (BFS)

- 双向搜索算法是一种图的遍历算法，用于在有向图中搜索从一个顶点到另一个顶点的最短路径问题
- 算法同时运行两个搜索：一个从初始状态正向搜索，另一个从目标状态反向搜索，当两者在中间汇合时搜索停止

### 启发式搜索（A*）

- 代码模板

```python
def AstarSearch(graph, start, end):
  # 优先级 —> 估价函数
	pq = collections.priority_queue() 
	pq.append([start])
	visited.add(start)
	while pq:
    # can we add more intelligence here ?
		node = pq.pop() 
		visited.add(node)
		process(node)
		nodes = generate_related_nodes(node)
		unvisited = [node for node in nodes if node not in visited]
		pq.push(unvisited)
```

- 启发函数：h(n)，用来评价哪些节点最有希望的是一个我们要找的节点，h(n)会返回一个非负实数，也可以认为是从结点n的目标结点路径的估 计成本
- 启发式函数是一种告知搜索方向的方法

## AVL树和红黑树

### AVL树

- AVL树是一个平衡二叉搜索树，每个节点左右两子树高度差不超多1

- Balance Factor（平衡因子）：节点的左子树的高度减去右子树的高度（有时相反），balance factor = {-1, 0, 1}

- 查找、插入、删除在平均和最坏情况下的时间复杂度：O(logn)，n是树中元素的数目

- 插入和删除操作可能需要一次或多次旋转实现树的重新平衡

- 四种旋转操作：

  ​	- 右右子树 —> 左旋

  ​	- 左左子树 —> 右旋

  ​	- 左右子树 —> 左右旋

  ​	- 右左子树 —> 右左旋

- 不足：节点需要存储额外信息、且调整次数频繁

### 红黑树

- 红黑树是一种近似平衡二叉搜索树，它能确保任何一个节点的左右子树高度差小于二倍

- 红黑树满足一下条件：

  ​	- 每个节点要么是红色，要么是黑色

  ​	- 根节点是黑色

  ​	- 每个叶子节点（NIL节点）是黑色

  ​	- 不能有两个相邻的红色节点

  ​	- 从任一个节点到其每个叶子节点所有路径都包含相同数目的黑色节点

- 关键性质：从根到叶子的最长的可能路径不多于最短的可能路径的两倍长
- 查找、插入、删除的时间复杂度：O(logn)，n是树中元素的数目

### AVL树和红黑树对比

- AVL树提供更快的查找比红黑树，因为AVL提供更严格平衡
- 红黑树提供了更快的插入和删除操作比AVL树，由于相对宽松的平衡，旋转次数较少
- AVL树每个节点需要存储平衡因子和高度，需要更多存储空间，而红黑树每个节点只需要用一个bit位来存储0和1表示红或者黑
- 大多数语言库都是使用的红黑树（Java1.8  Map），AVL树则用于需要更快检索的数据库

