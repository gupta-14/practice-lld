package DSA.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class Node{
        int key,value;
        Node prev, next;

        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private Map<Integer, Node> cache = new HashMap<>();
    private Node left, right;

    public LRUCache(int capacity){
        this.capacity = capacity;
        left = new Node(0,0); // left = LRU
        right = new Node(0,0); // right = MRU
        left.next = right;
        right.prev = left;
    }

    // remove the node from list
    private void remove(Node node){
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }

    // insert node at the right
    private void insert(Node node){
        Node prev = right.prev;
        Node nxt = right;
        node.next = nxt;
        prev.next = node;
        node.prev = prev;
        nxt.prev = node;
    }

    public int get(int key){
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value){
        if (cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);
        if (cache.size() > capacity){
            // remove from the list and delete the LRU from the hashmap
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

}
