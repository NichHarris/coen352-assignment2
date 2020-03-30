// Nicholas Harris
// 40111093

/* 3.1.3 Develop a symbol-table implementation OrderedSequentialSearchST that uses an
ordered linked list as the underlying data structure to implement our ordered symbol-table APL */

import java.io.BufferedReader;
import java.util.*;

/* public class ST<Key extends Comparable<Key>, Value>

ST() create an ordered symbol table
put(Key, key, Value val) put key-value pair into the table (remove key from table if value is null)
Value get(Key key) value paired with key (null if key is absent)
void delete(Key key) remove key (and its value) from table)
boolean contains(Key key) is there a value paired with the key?
boolean isEmpty() is the table empty?
int size() number of key-value pairs in the table
Key min() smallest key
Key max() largest key
Key floor(Key key) largest key less than or equal to key
Key ceiling(Key key) smallest key greater than or equal to key
int rank(Key key) number of keys less than key
Key select(int k) key of rank k
void deleteMin() delete smallest key
void deleteMax() delete largest key
int size(Key lo, Key hi) number of keys in [lo..hi]
Iterable<Key> keys(Key lo, Key hi) keys in [lo..hi], in sorted order
Iterable<key> keys() all keys in the table, in sorted order
API for a generic ordered symbol table */

public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {
    private Node first = null;
    private int size = 0;

    public OrderedSequentialSearchST() {
        first = null;
        size = 0;
    }

    private class Node{
        Key key;
        Value value;
        Node next;
        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    public void put(Key key, Value value) {
        if(key == null){
            delete(key);
        }
        if(first == null){
            first = new Node(key,value);
            size++;
            return;
        }
        Node current = first;
        while(current.next != null && current.next.key.compareTo(key) < 0){
            current = current.next;
        }
        if(current.key.compareTo(key) == 0){
            current.value = value;
            return;
        }
        Node node = new Node(key,value);
        node.next = current.next;
        current.next = node;
        size++;
    }

    public Value get(Key key) {
        Node current = first;
        while(current != null){
            if(current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void delete(Key key) {
        if(first == null){
            return;
        }
        if(first.key.compareTo(key) == 0){
            first = first.next;
            size--;
            return;
        }
        Node current = first;
        while(current.next != null){
            if(current.key.compareTo(key) == 0){
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    public boolean contains(Key key) {
        Node current = first;
        while(current != null && current.key.compareTo(key) <= 0){
            if(current.key.compareTo(key) == 0){
                return 1;
            }
            current = current.next;
        }
        return 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size(){
        return size;
    }

    public Key min() {
        if(first == null){
            return null;
        }
        return first.key;
    }
    
    public Key max() {
        if(first == null){
            return null;
        }
        Node current = first;
        while(current.next != null){
            current = current.next;
        }
        return current.key;
    }

    public Key floor(Key key) {
        if(first == null || first.key.compareTo(key) > 0){
            return null;
        }
        Node current = first;
        while(current.next != null && current.next.key.compareTo(key) <= 0){
            current = current.next;
        }
        return current.key;
    }

    public Key ceiling(Key key) {
        if(first == null){
            return null;
        }
        Node current = first;
        while(current != null && current.next.key.compareTo(key) < 0){
            current = current.next;
        }
        if(current == null){
            return null;
        }
        return current.key;
    }

    public int rank(Key key){
        if(first == null){
            return 0;
        }
        int rank = 0;
        Node current = first;
        while(current != null && current.key.compareTo(key) < 0){
            rank++;
            current = current.next;
        }
        return rank;
    }

    public Key select(int rank){
        if(first == null){
            return null;
        }
        Node current = first;
        while(rank != 0){
            current = current.next;
            if(current == null){
                return null;
            }
            rank--;
        }
        return current.key;
    }

    public void deleteMin(){
        if(first == null){
            return;
        }
        first = first.next;
        size--;
    }

    public void deleteMax(){
        if(first == null){
            return;
        }
        Node current = first;
        while(current.next != null){
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public int size(Key low, Key high){
        int diff = 0;
        if(first == null){
            return 0;
        }
        Node current = first;
        while(current != null && current.key.compareTo(low) < 0){
            current = current.next;
        }
        if(current == null){
            return 0;
        }
        while(current != null && current.key.compareTo(high) <= 0){
            current = current.next;
            diff++;
        }
        return diff;
    }

    public Iterable<Key> keys(Key low, Key high) {
        ArrayDeque<Key> queue = new ArrayDeque<>();
        if(first == null){
            return queue;
        }
        Node current = first;
        while(current != null && current.key.compareTo(low) < 0){
            current = current.next;
        }
        while(current != null && current.key.compareTo(high) <= 0){
            queue.add(current.key);
            current = current.next;
        }
        return queue;
    }

    public Iterable<Key> keys() {
        return keys(select(0), select(this.size - 1));
    }
    
    public static void main(String[] args) {
        OrderedSequentialSearchST<Integer, Integer> st = new OrderedSequentialSearchST<>();
        Random rand = new Random();
        for(int key = 0; key < 20; key++){
            int value = rand.nextInt(100);
            st.put(key, value);
        }
        System.out.println("Output ST");
        for (Integer key : st.keys()){
            System.out.println(key + " " + st.get(key));
        }
        System.out.println("ST Size: " + st.size());
        System.out.println("Testing deleteMin/Max");
        for(int i = 2; i != 0; i--){
            System.out.println("Deleted Min");
            System.out.println(st.get(st.min()));
            st.deleteMin();
            System.out.println("Deleted Max");
            System.out.println(st.get(st.max()));
            st.deleteMax();
        }
        System.out.println("Output New ST");
        for(Integer key : st.keys()){
            System.out.println(key + " " + st.get(key));
        }
        System.out.println("New ST Size: " + st.size());
    }
}