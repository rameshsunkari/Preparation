package com.prac.edgeverve;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/*class Node{
    int key;
    String value;
    Node pre;
    Node next;
 
    public Node(int key, String value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
 
    public String get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
 
        return null;
    }
 
    public void remove(Node n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
 
        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
 
    }
 
    public void setHead(Node n){
        n.next = head;
        n.pre = null;
 
        if(head!=null)
            head.pre = n;
 
        head = n;
 
        if(end ==null)
            end = head;
    }
 
    public void set(int key, String value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
 
            }else{
                setHead(created);
            }    
 
            map.put(key, created);
        }
    }
    
    public void show() {
    	for(int key:map.keySet()) {
    		System.out.println(map.get(key).value);
    	}
    }
}*/

class LRUCache < K, V > extends LinkedHashMap < K, V > {
	 
    private int capacity; // Maximum number of items in the cache.
     
    public LRUCache(int capacity) { 
        super(capacity+1, 1.0f, true); // Pass 'true' for accessOrder.
        this.capacity = capacity;
    }
     
    protected boolean removeEldestEntry(Entry entry) {
        return (size() > this.capacity);
    } 
}

public class BrowserCache {

	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n<=0) {
			return;
		}
		
		LRUCache<Integer, String> lru = new LRUCache<Integer,String>(n);
		int i = 1;
		while(i<n) {
			String str = sc.next();
			
		
			i++;
		}
		
		
		

	}

}
