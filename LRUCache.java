import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache.
 * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * Example 1:
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * Constraints:
 * 1 <= capacity <= 3000
 * 0 <= key <= 10^4
 * 0 <= value <= 10^5
 * At most 2 * 10^5 calls will be made to get and put.
 */
public class LRUCache {
    private Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        // load Factor = 1.0, accessOrder = true
        cache = new LinkedHashMap(capacity, 1.0f, true) {
            @Override
            // LinkedHashMap method
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if(cache.get(key) == null) return -1;
        return cache.get(key);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1) + " = 1");
        obj.put(3,3);
        System.out.println(obj.get(2) + " = -1");
        obj.put(4,4);
        System.out.println(obj.get(1) + " = -1");
        System.out.println(obj.get(3) + " = 3");
        System.out.println(obj.get(4) + " = 4");

        LRUCache obj1 = new LRUCache(2);
        obj1.put(2,1);
        obj1.put(2,2);
        System.out.println(obj1.get(2) + " = 2");
        obj1.put(1,1);
        obj1.put(4,1);
        System.out.println(obj1.get(2) + " = -1");

        LRUCache obj2 = new LRUCache(2);
        System.out.println(obj2.get(2) + " = -1");
        obj2.put(2,6);
        System.out.println(obj2.get(1) + " = -1");
        obj2.put(1,5);
        obj2.put(1,2);
        System.out.println(obj2.get(1) + " = 2");
        System.out.println(obj2.get(2) + " = 6");
    }
}

