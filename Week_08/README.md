## 学习笔记
## 16、位运算

- 为什么需要位运算：机器里数字表示方式和存储格式就是二进制
- 常用位运算符：

| 含义 |            运算符            |
| :--: | :--------------------------: |
|  >>  |         左移（除2）          |
|  <<  |         右移（乘2）          |
|  \|  |             位或             |
|  &   |             位与             |
|  ~   |           按位取反           |
|  ^   | 按位异或（相同为零不同为一） |

- 异或操作：

  ​	- x ^ 0 = x

  ​	- x ^ 1s = ~x 	// 注意 1s = ~0

  ​	- x ^ (~x) = 1s

  ​	- x ^ x = 0

  ​	- c = a ^ b => a ^ c = b, b ^ c = a 		// 交换两个数

  ​	- a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c 	// associative

- 指定位置的位运算

  ​	- 将 x 最右边的 n 位清零：x & (~0 << n)

  ​	- 获取 x 的第 n 位值（0 或者 1）： (x >> n) & 1

  ​	- 获取 x 的第 n 位的幂值：x & (1 << n)

  ​	- 仅将第 n 位置为 1：x | (1 << n)

  ​	- 仅将第 n 位置为 0：x & (~ (1 << n))

  ​	- 将 x 最高位至第 n 位（含）清零：x & ((1 << n) - 1)

- 实战运算要点：

  ​	- 判断奇偶：x % 2 == 1 —> (x & 1) == 1    x % 2 == 0 —> (x & 1) == 0

  ​	- x >> 1 —> x / 2

  ​	- X = X & (X-1) 清零最低位的1

  ​	- X & -X => 得到最低位的1

  ​	- X & ~X => 0

## 17、布隆过滤器和LRU缓存

### Bloom Filter

- 核心实现是一个很长的位数组和几个哈希函数

- 用于检索一个元素是否在一个集合中，空间效率和查询效率高，有一定误判率和删除困难

- 示意图：

  ![img](https://gitee.com/kingoooo/typora/raw/master/img/1030776-20170106143141784-1475031003.png)

- 添加元素：将添加的元素经过k个哈希函数计算，对应位数组上的k个位置设为1

- 查询元素：将查询的元素经过k个哈希函数计算，对应位数组上的k个位置有一个0，则肯定不在集合中；如果k个位置全部为1，则可能在集合中

- 实例代码：

  ​	- https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java

  ​	- https://github.com/Baqend/Orestes-Bloomfilter

### LRU Cache

- 查询、修改时间复杂度：O(1)
- 实现方式：Hash Table + Double LinkedList
- LRU - least recently used
- LFU - least frequently used
- 替换算法总览： https://en.wikipedia.org/wiki/Cache_replacement_policies
- Java代码模板：

```java
public class LRUCache {
    private Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        map = new LinkedCappedHashMap<>(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    private static class LinkedCappedHashMap<K, V> extends LinkedHashMap<K, V> {
        int maximumCapacity;

        LinkedCappedHashMap(int maximumCapacity) {
            super(16, 0.75f, true);
            this.maximumCapacity = maximumCapacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > maximumCapacity;
        }
    }
}
```

## 18、排序算法

- **比较类排序：**通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序

- **非比较类排序**：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序

- ![img](https://gitee.com/kingoooo/typora/raw/master/img/image-20210124192957241.png)

- ![img](https://gitee.com/kingoooo/typora/raw/master/img/image-20210124193512979.png)

- 初级排序 - O(n^2)

  ​	- 选择排序（Selection Sort）：每次找最小值，然后放到待排序数组的起始位置

  ​	- 插入排序（Insertion Sort）：从前到后逐步构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入

  ​	- 冒泡排序（Bubble Sort）：嵌套循环，每次查看相邻的元素如果逆序，则交换

- 高级排序 - O(N*LogN)

    - 快速排序（Quick Sort）：数组取标杆pivot，将小元素放pivot左边，大元素放右侧，然后依次对右边和右边的子数组继续快排

      ```java
      public static void quickSort(int[] array, int begin, int end) {
          if (end < begin) {
              return;
          }
          int pivot = partition(array, begin, end);
          quickSort(array, begin, pivot - 1);
          quickSort(array, pivot + 1, end);
      }
      static int partition(int[] a, int begin, int end) {
          int pivot = end, counter = begin;
          for (int i = begin; i < end; i++) {
              if (a[i] < a[pivot]) {
                  int temp = a[counter];
                  a[counter] = a[i];
                  a[i] = temp;
                  counter++;
              }
          }
          int temp = a[pivot];
          a[pivot] = a[counter];
          a[counter] = temp;
          return counter;
      }
      ```

    - 归并排序（Merge Sort）—分治

      ​	- 把长度为n的输入序列分成两个长度为n/2的子序列

      ​	- 对这两个子序列分别采用归并排序

      ​	- 将两个排序好的子序列合并成一个最终的排序序列

      ```java
      public static void mergeSort(int[] array, int left, int right) {
          if (right < left) {
              return;
          }
          int mid = (left + right) >> 1;
          mergeSort(array, left, mid);
          mergeSort(array, mid + 1, right);
          merge(array, left, mid, right);
      }
      public static void merge(int[] arr, int left, int mid, int right) {
          int[] temp = new int[right - left + 1];
          int i = left, j = mid + 1, k = 0;
          while (i <= mid && j <= right) {
              temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
          }
          while (i <= mid) {
              temp[k++] = arr[i++];
          }
          while (j <= right) {
              temp[k++] = arr[j++];
          }
          for (int p = 0; p < temp.length; p++) {
              arr[left + p] = temp[p];
          }
          // 也可以用 System.arraycopy(a, start1, b, start2, length)
      }
      ```

    - 堆排序（Heap Sort）：堆插入O(logN)，取最大/小值O(1)

      ​	- 数组元素依次建立小顶堆

      ​	- 依次取堆顶元素，并删除

      ```java
      public void heapSort(int[] array) {
          int length = array.length;
          if (length == 0) {
              return;
          }
          for (int i = length / 2 - 1; i >= 0; i--) {
              heapify(array, length, i);
          }
          for (int i = length - 1; i >= 0; i--) {
              int temp = array[0];
              array[0] = array[i];
              array[i] = temp;
              heapify(array, i, 0);
          }
      }
      public static void heapify(int[] array, int length, int i) {
          int left = 2 * i + 1, right = 2 * i + 2;
          int largest = i;
          if (left < length && array[left] > array[largest]) {
              largest = left;
          }
          if (right < length && array[right] > array[largest]) {
              largest = right;
          }
          if (largest != i) {
              int temp = array[i];
              array[i] = array[largest];
              array[largest] = temp;
              heapify(array, length, largest);
          }
      }
      ```

    - 特殊排序-O(n)

      ​	- 计数排序（Counting Sort）：计数排序要求输入的数据必须是有确定范围的整数。将输入的数据值转化为键存储在额外开辟的数组空间中；然后依次把计数大于1 的填充回原数组

      ​	- 桶排序（Bucket Sort）：桶排序(Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）

      ​	- 基数排序（Radix Sort）：基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序