import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _146_LRUCache
 * @Description: 146. LRU 缓存机制
 * @Author: wangchangyong
 * @Date: 2021/1/24 14:39
 * @Version: 1.0.0
 **/
public class _146_LRUCache {

    // 缓存大小
    private int size;
    // 缓存容量
    private int capacity;
    // HashMap缓存
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    // 虚拟头结点和尾结点
    private DLinkedNode head, tail;


    /**
     * 以正整数作为容量 capacity 初始化 LRU 缓存
     * @param capacity
     */
    public _146_LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 初始化虚拟头尾节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }

    /**
     * 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1
     * @param key
     * @return
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 移动节点
        moveToHead(node);
        return node.getValue();
    }

    /**
     * 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 创建一个新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加cache
            cache.put(key, newNode);
            // 添加双向链表头部结点
            addToHead(newNode);
            // 容量判断是否超出容量
            if (++size > capacity) {
                // 删除尾部结点
                DLinkedNode tailNode = removeTail();
                // 删除cache对应的项
                cache.remove(tailNode.getKey());
                --size;
            }
        } else {
            // 更新节点value
            node.value = value;
            // 链表节点移动到头部
            moveToHead(node);
        }
    }

    /**
     * 双向链表节点
     */
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public DLinkedNode getPrev() {
            return prev;
        }

        public void setPrev(DLinkedNode prev) {
            this.prev = prev;
        }

        public DLinkedNode getNext() {
            return next;
        }

        public void setNext(DLinkedNode next) {
            this.next = next;
        }

        public DLinkedNode() {
        }

        ;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 添加头部结点
     */
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 移动接点到头部
     */
    private void moveToHead(DLinkedNode node) {
        // 删除原来节点
        removeNode(node);
        // 添加到头部
        addToHead(node);
    }

    /**
     * 删除节点
     */
    private void removeNode(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    /**
     * 删除尾部节点
     * @return
     */
    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

}
