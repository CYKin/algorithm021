## 学习笔记
## 9、深度优先搜索和广度优先搜索

- 搜索：每个节点仅仅访问一次
- 时间复杂度和空间复杂度：O(n)

### 深度优先搜索 Depth First Search

- 递归、栈实现搜索
- 递归代码模板

```python
visited = set()
def dfs(node, visited):
  # terminator
  if node in visited: 
    # already visited
    return
    visited.add(node)
  # process current node here.
  ...
  for next_node in node.children():
    if not next_node in visited:
    dfs(next node, visited)
```

### 广度优先搜索 Breadth First Search

- 队列实现搜索
- 队列代码模板

```python
def BFS(graph, start, end):
  queue = []
  queue.append([start])
  visited.add(start)
while queue:
  node = queue.pop()
  visited.add(node)
  process(node)
  nodes = generate_related_nodes(node)
  queue.push(nodes)
```

## 10、贪心算法 Greedy

- 是一种在每一步选择中都采用在当前状态下最好或最优的选择，从而希望导致结果是全局最好或最优的算法
- 解决最优问题
- 贪心算法高效以及其所求得的答案比较接近最优结果，贪心算法可用作辅助算法或者直接解决一些要求结果不是很精确的问题
- 使用场景：最优子结构
- 贪心算法与动态规划的不通在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运行结果，并根据以前的结果对当前进行选择，有回退功能

## 11、二分查找 BinarySearch

- 二分查找的前提

  ​	- 目标函数单调性

  ​	- 存在上下界

  ​	- 能够通过索引访问

- Java代码模板

```java
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
}
```

- 寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

```java
/**
 * 寻找半有序数组中间无序的地方 -> 寻找数组中最小值的index
 * 二分查找
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 */
public int findMinIndex(int[] nums) {
    int i = 0;
    int j = nums.length - 1;
    // 初始化最小值和最小值index
    int min = nums[0];
    int minIndex = 0;
    while (i <= j) {
        int mid = i + (j - i) / 2;
        // 前半部分升序
        if (nums[i] <= nums[mid]) {
            // 前半部分第一个数与最小数取值min
            if (min > nums[i]) {
                min = nums[i];
                minIndex = i;
            }
            // 查找后半部分区间最小数和index
            i = mid + 1;
        } else {
            // 后半部分升序 后半部分第一个数与最小数取值min
            if (min > nums[mid]) {
                min = nums[mid];
                minIndex = mid;
            }
            // 查找前半部分区间最小数和index
            j = mid - 1;
        }
    }
    return minIndex;
}
```

