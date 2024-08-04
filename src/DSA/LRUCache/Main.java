package DSA.LRUCache;

public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,10);
        cache.put(5,12);
        System.out.println(cache.get(5));
        System.out.println(cache.get(1));
        System.out.println(cache.get(10));
        cache.put(6,14);
        System.out.println(cache.get(5));
    }
}
