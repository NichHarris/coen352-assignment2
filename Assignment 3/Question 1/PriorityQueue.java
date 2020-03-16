
//Nicholas Harris
//harris.nicholas1998@gmail.com

/* 2.4.29 Min/max priority queue. Design a data type that supports the following operations: insert,
delete the maximum, and delete the minimum (all in logarithmic time); and find the maximum and
find the minimum (both in constant time). Hint Use two heaps. */

import java.util.Random;
import java.lang.MinHeap;
import java.lang.MaxHeap;
    
public class PriorityQueue{
    public static void main(String[] args){
        Random rand = new Random();
        MaxHeap maxQueue = new MaxHeap();
        MinHeap minQueue = new MinHeap();
        for(int i = 0; i < 16; i++){
           int data = rand.nextInt(100);
           maxQueue.insert(data);
           minQueue.insert(data);
        }
        System.out.println("Max heap: " );
        maxQueue.print();
        System.out.println("Min heap: " );
        minQueue.print();
        System.out.print("Max element: " + maxQueue.findMax());
        System.out.print("\nMin element: " + minQueue.findMin());
        System.out.print("\nRemove max element: ");
        maxQueue.deleteMax();
        System.out.print("\nNew max element: " + maxQueue.findMax());
        System.out.print("\nRemove min element: ");
        minQueue.deleteMin();
        System.out.print("\nNew min element: " + minQueue.findMin());
    }
}