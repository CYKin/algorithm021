# 学习笔记
## 3、数组、链表、跳表

### 数组 Array

- prepend、append、lookup = O(1)，insert、delete = O(n)

- Memory Controller在内存开辟一块连续内存地址

- 通过Memory Controller随机访问任何一个元素，插入和删除需要挪动元素

- 有序数组用二分查找

  

### 链表  Linked List

- prepend、append、insert、delete = O(1)，lookup = O(n)
- 只有next指针是单向链表
- next、prev指针是双向链表
- 最后一个节点next指向头结点是循环链表



### 跳表  Skip List

- 元素有序
- 解决有序链表查询效率（升纬、空间换时间）
- 添加、删除、查询 = O(logn)，空间复杂度 O(n)
- 跳表索引的高度 logn
- 原理简单、容易实现，但维护成本高，添加、删除需要更新索引



## 4、栈、队列

### 栈 Stack

- 先进后出 FILO

- 添加、删除 = O(1)，查询 = O(n)

- 原理：

  ​	- extend Vector（线程安全）

  ​	- 底层实现：数组

- 用于解决最近相关性等问题

### 队列 Queue

- 先进先出 FIFO

- 原理：

  ​	- extend Collection

  ​	- 底层实现：数组、链表

- 用于解决先来后到等问题

- 双端队列 Deque

  ​	- 添加、删除 = O(1)，查询 = O(n)

  ​	- 队列前后都可以插入数据删除数据

  ​	- extend Queue

- 优先队列 PriorityQueue

  ​	- 添加、删除 = O(1)，取出= O(logN)，按照元素优先级取出

  ​	- 有序列表，存储到队列中的元素会按照自然顺序排序

  ​	- 实现java.util.Comparator接口排序类来指定元素排序的顺序