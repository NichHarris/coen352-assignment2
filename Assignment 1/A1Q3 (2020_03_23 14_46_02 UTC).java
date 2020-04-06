//Nicholas Harris
//harris.nicholas1998@gmail.com

import java.util.Iterator;

public class A1Q3 {

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

        public Integer max(){
            Node node = first;
            if(node == null){
                return null;
            }
            int max = Integer.parseInt(node.item.toString());
            while(node.next != null){
                int temp = Integer.parseInt(node.next.item.toString());
                if(temp > max){
                    max = temp;
                }
                node = node.next;
            }       
            return max;
        }
    } 
    public static void main(String[] args){
        MyLinkedList<Integer> object = new MyLinkedList<Integer>();
        object.add(10);
        object.add(15);
        object.add(16);
        object.add(4);
        object.add(40);
        int max = object.max();
        System.out.print(max);
    }
}