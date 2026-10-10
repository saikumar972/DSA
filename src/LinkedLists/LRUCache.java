package LinkedLists;

import java.util.HashMap;

class LRUCache {

    int capacity;
    HashMap<Integer, CacheNode> map;
    CacheNode head;
    CacheNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new CacheNode(-1, -1);
        this.tail = new CacheNode(-1, -1);
        head.nextNode = tail;
        tail.prevNode = head;
    }

    public static void main(String[] args) {

        System.out.println("========== LRU CACHE TEST ==========");

        LRUCache cache = new LRUCache(2);

        // Test 1: Add two elements
        System.out.println("\n--- Test 1: Adding elements ---");

        cache.put(1, 10);
        System.out.println("put(1, 10)");

        cache.put(2, 20);
        System.out.println("put(2, 20)");

        System.out.println("get(1) = " + cache.get(1) + "  | Expected: 10");
        System.out.println("get(2) = " + cache.get(2) + "  | Expected: 20");

        // Test 2: Eviction
        System.out.println("\n--- Test 2: LRU Eviction ---");

        cache.put(3, 30);
        System.out.println("put(3, 30)");

        System.out.println("get(1) = " + cache.get(1) + "  | Expected: -1");
        System.out.println("get(2) = " + cache.get(2) + "  | Expected: 20");
        System.out.println("get(3) = " + cache.get(3) + "  | Expected: 30");

        // Test 3: Update existing key
        System.out.println("\n--- Test 3: Update existing key ---");

        cache.put(2, 200);
        System.out.println("put(2, 200)");

        System.out.println("get(2) = " + cache.get(2) + "  | Expected: 200");

        // Test 4: Access MRU element
        System.out.println("\n--- Test 4: Access MRU element ---");

        System.out.println("get(2) = " + cache.get(2) + "  | Expected: 200");

        cache.put(4, 40);
        System.out.println("put(4, 40)");

        System.out.println("get(3) = " + cache.get(3) + "  | Expected: -1");
        System.out.println("get(2) = " + cache.get(2) + "  | Expected: 200");
        System.out.println("get(4) = " + cache.get(4) + "  | Expected: 40");

        System.out.println("\n========== TEST COMPLETE ==========");
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            moveNodeToHead(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            CacheNode node = map.get(key);
            node.value = value;
            moveNodeToHead(node);
        } else if (map.size() >= capacity) {
            removeFromTail();
            addToHead(key, value);
        } else {
            addToHead(key, value);
        }

    }

    public void addToHead(int key, int value) {
        CacheNode node = new CacheNode(key, value);
        CacheNode headNextNode = head.nextNode;
        head.nextNode = node;
        node.nextNode = headNextNode;
        headNextNode.prevNode = node;
        node.prevNode = head;

        map.put(key, node);
    }

    private void removeFromTail() {
        CacheNode previousNode = tail.prevNode;
        previousNode.nextNode = tail;
        tail.prevNode = previousNode;
        map.remove(previousNode.key);
    }

    private void moveNodeToHead(CacheNode node) {
        if (node == head.nextNode) {
            return;
        }  
        CacheNode nextNode = node.nextNode;
        CacheNode prevNode = node.prevNode;
        CacheNode headNextNode = head.nextNode;

        node.nextNode = headNextNode;
        node.prevNode = head;

        head.nextNode = node;
        headNextNode.prevNode = node;

        nextNode.prevNode = prevNode;
        prevNode.nextNode = nextNode;
    }

}

class CacheNode {
    CacheNode prevNode;
    int key;
    int value;
    CacheNode nextNode;

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public CacheNode(int key, int value, CacheNode prevNode, CacheNode nextNode) {
        this.prevNode = prevNode;
        this.value = value;
        this.key = key;
        this.nextNode = nextNode;
    }
}