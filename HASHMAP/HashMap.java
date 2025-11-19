package HASHMAP;
import java.util.*;

public class HashMap<K, V> {
    class Node {
        K key;
        V value;
        Node next;
    }
    
    private int size = 0;
    ArrayList<Node> bukt = new ArrayList<>();
    
    public HashMap() {
        this(4);
    }
    
    public HashMap(int n) {
        for(int i = 0; i < n; i++) {
            bukt.add(null);
        }
    }
    
    private int hashFunction(K key) {
        int hc = key.hashCode();
        int idx = Math.abs(hc) % bukt.size();
        return idx;
    }
    
    public void put(K key, V value) {
		int idx = hashFunction(key);
		Node temp = bukt.get(idx);
		while(temp != null) {
			if(temp.key.equals(key)) {
				temp.value = value;
				return;
			}
        }
    }
    
    private void reHashing() {
        ArrayList<Node> oldBucket = bukt;
        bukt = new ArrayList<>();
        size = 0;
        
        // Double the bucket size
        for(int i = 0; i < oldBucket.size() * 2; i++) {
            bukt.add(null);
        }
        
        // Rehash all existing elements
        for(Node head : oldBucket) {
            while(head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }


}
