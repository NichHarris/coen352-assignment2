public class MinHeap{
    private int[] heap;
    private int size;
    private int maxSize = 16;

    public MinHeap(){
        heap = new int[maxSize];
        size = 0;
    }

    public void insert(int data){
        if(size >= maxSize){
            System.out.println("Heap is full");
            return;
        }
        heap[size] = data;
        size++;
        int current = size -1;
        while(heap[current] < heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void deleteMin(){
        heap[0] = heap[size-1];
        size--;
        minHeapify(0);
    }

    public int findMin(){
        return heap[0];
    }

    public static int parent(int i){
        return (i - 1)/2;
    }

    public static int right(int i){
        return (2*i + 2);
    }

    public static int left(int i){
        return (2*i + 1);
    }

    public void minHeapify(int i){
        int left = MinHeap.left(i);
        int right = MinHeap.right(i);
        int smallest = i;
        if(left <= size && heap[left] < heap[smallest]){
            smallest = left;
        }
        if(right <= size && heap[right] < heap[smallest]){
            smallest = right;
        }
        if(smallest != i){
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    private void swap(int first, int second){
        int temp;
        temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    public void print(){
        for(int i = 0; i < (size-1)/2; i++){
            System.out.println("Parent: " + heap[i] + " Left Child: " + heap[left(i)] + " Right Child: " + heap[right(i)]);
        }
    }
}