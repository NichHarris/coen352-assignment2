//Nicholas Harris
//harris.nicholas1998@gmail.com

/* Sublinear extra space. Develop a merge implementation that reduces the extra space
requirement to max(M, N/M), based on the following idea: Divide the array into N/M blocks of
size M (for simplicity in this description, assume that N is a multiple of M). Then, (i) considering
the blocks as items with their first key as the sort key, sort them using selection sort; and (ii) run
through the array merging the first block with the second, then the second block with the third,
and so forth. */

import java.util.Random;

public class A2Q2 {

    public static void selectionSort(Integer[] arr, int lo, int hi) { 
        for (int i = lo; i < hi; i++) { 
            int min = i; 
            for (int j = i+1; j < hi; j++) {
                if (arr[j] < arr[min]) {
                    min = j; 
                }
            }
            swap(arr, i, min);
        } 
    }

    public static void swap(Integer[] arr, int i, int k){
        int temp = arr[k];
        arr[k] = arr[i];
        arr[i] = temp;
    }

    public static void mergeSort(Integer[] arr, int lo, int mid, int hi){
        Integer[] temp = new Integer[arr.length];
        int x = lo;
        int y = mid;
        for(int i = lo; i < hi; i++){
            temp[i] = arr[i];
        }

        for(int j = lo; j < hi; j++){
            if(x >= mid){
                arr[j] = temp[y++];
            }
            else if(y >= hi){
                arr[j] = temp[x++];
            }
            else if(temp[x] < temp[y]){
                arr[j] = temp[x++];
            }
            else{
                arr[j] = temp[y++];
            }
        }
    }

    public static void print(Integer[] arr, int start, int len){
        for(int i = start; i < len; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args){
        int N = 16;
        int M = 4;
        int blocks = N/M;
        Integer[] array = new Integer[N];
        Random rand = new Random();
        for(int i = 0; i < N; i++){
            array[i] = rand.nextInt(1000);
        }
        System.out.print("Original Array: ");
        print(array, 0, N);
        for(int i = 0; i < N; i = i + M){
            selectionSort(array, i, i + M);
            System.out.print("\nSelection sort on block " + i/M + ": ");
            print(array, i, i + M);
        }
        System.out.print("\nFull Array after selection sort on blocks: ");
        print(array, 0, N);
        int start = 0;
        for(int i = 0; i < blocks - 1; i++){
            System.out.print("\nMerging blocks " + i + " and " + (i + 1) + ": ");
            mergeSort(array, 0, M*(i+1), M*(i+2));
            print(array, start, (start + 2*M));
            start = start + M;
        }
        System.out.print("\nFinal result: ");
    }
}