## 学习笔记
##  19、高级动态规划

- 状态转换成多维度

## 20、字符串

- 常见问题：异位词、回文串、最长子序列、最长子串、编辑距离

- 常见解决办法：递归或动态规划

- 字符串匹配算法

  ​	- 暴力算法：挨个比较所有字符

  ​	- Rabin Karp算法：通过哈希函数算出子串的哈希值，然后将它和目标字符串中的子串的哈希值进行比较，尝试一次性判断

  ​	- Rabin Karp算法思想：

  ​		- 假设子串的长度为M(pat)，目标字符串的长度为N(txt)

  ​		- 计算子串的hash值hash_pat

  ​		- 计算目标字符串txt中每个长度为M的子串的hash值（共需要计算N-M+1次）

  ​		- 比较hash值：如果hash值不同，字符串必然不匹配；如果hash值相同，还需要使用朴素算法再次判断

  ​	- Rabin Karp代码示例：

```java
public final static int D = 256;
public final static int Q = 9997;
static int RabinKarpSerach(String txt, String pat) {
    int M = pat.length();
    int N = txt.length();
    int i, j;
    int patHash = 0, txtHash = 0;
    for (i = 0; i < M; i++) {
        patHash = (D * patHash + pat.charAt(i)) % Q;
        txtHash = (D * txtHash + txt.charAt(i)) % Q;
    }
    int highestPow = 1; // pow(256, M-1)
    for (i = 0; i < M - 1; i++) {
        highestPow = (highestPow * D) % Q;
    }
    for (i = 0; i <= N - M; i++) { // 枚举起点
        if (patHash == txtHash) {
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                return i;
            }
        }
        if (i < N - M) {
        		txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + M)) % Q;
            if (txtHash < 0) {
                txtHash += Q;
            }
        }
    }
    return -1;
}
```

​		- KMP算法：Knuth-Morris-Pratt，当子串与目标字符串不匹配时，其实已经知道前面已经匹配成功的那一部分字符。KMP算法的思想就是利用这个已知信息，不要把搜索位置移回已经比较过的位置，继续把它向后移，这样就提高效率

​			- KMP算法思想讲解：https://www.bilibili.com/video/av11866460?from=search&seid=17425875345653862171

​			- KMP算法代码讲解：https://www.bilibili.com/video/BV1hW411a7ys/?spm_id_from=333.788.videocard.0