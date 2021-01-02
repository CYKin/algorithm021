# 学习笔记
## 7、递归 Recursion

- 通过函数体来进行循环
- Java代码模板

```java
public void recur(int level, int param) {
    // 递归终结条件
    if (level > MAX_LEVEL) {
        // process result
        return;
    }
    // 处理当前层逻辑
    process(level, param);
  	// 下探到下一层
    recur( level: level + 1, newParam);
  	// 清理当前层
}
```

- 思路：

  ​	- 拒绝无脑递归

  ​	- 将其拆解成可重复解决的子问题

  ​	- 数学归纳法思维

## 8、分治、回溯

- 是一种特殊的递归
- 找重复性以及分解问题和最后组合每个子问题的结果
- 最近重复性 -> 分治、回溯
- 最优重复性 -> 动态规划

### 分治 Divide & Conquer

- 终结条件
- 分解问题
- 下探到下一层， 合并子问题结果
- 清理当前层

### 回溯 Backtracking

- 分步解决问题
- 分步解决答案不是有效的正确解答，取消上一步或上几步的计算
- 通过其他分步解决再次尝试寻找问题的答案