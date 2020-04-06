//Nicholas Harris
//harris.nicholas1998@gmail.com

import java.io;
import java.util.Iterator;

public class A1Q2 {


    public static class MyLinkedList<Item> implements Iterable<Item>{
        private Node first = null;
        private Node last = null;
        private int size = 0;

        private class Node{
            Item item;
            Node next;
        }

        public int sizeof(){
            return size;
        }

        public void add(Item item){
            Node old = last;
            last = new Node();
            last.item = item;
            last.next = null;

            if(first == null){
                first = last;
            }
            else{
                old.next = last;
            }
            size++;
        }

        public Iterator<Item> iterator() {
            return new ListIterator();
        }
        
        public class ListIterator implements Iterator<Item>{
            private Node current = first;

            public boolean hasNext(){
                return current != null;
            }

            public void remove(){}

            public Item next(){
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
        public void delete(int k){
            if(k == 1){
                first = null;
                last = null;
                size--;
            }
            else{
                Node node = first;
                for(int i = 2; i < k; i++){
                    node = node.next;
                }
    
                if(node.next.next == null){ // k is the last node
                    node.next = null;
                    size--;
                }
                else{ // shift the next node left
                    node.next = node.next.next;
                }
            }
        }
    }


    public static void main(String[] args){
        MyLinkedList<String> object = new MyLinkedList<String>();
        object.add("A");
        object.add("B");
        object.add("C");
        object.add("D");
        object.add("E");
        int k = 3;
        object.delete(k);
        for(String str : object){
            System.out.print(str + " ");
        }
    }
}