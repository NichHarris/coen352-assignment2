// Nicholas Harris
// harris.nicholas1998@gmail.com

/* Indirect sort. Develop and implement a version of mergesort that does not re-arrange the
array, but returns an int[] array perm such that perm [i] is the index of the ith smallest 
entry in the array. */

import java.util.Random;

public class A2Q3 {

    public static Integer[] mergeSort(Integer[] arr, Integer[] perm, int lo, int mid, int hi){
        Integer[] temp = new Integer[arr.length];
        int x = lo;
        int y = mid + 1;
        for(int i = lo; i <= hi; i++){
            temp[i] = arr[i];
        }

        for(int j = lo; j < hi; j++){
            if(x > mid){
                perm[j] = temp[y++];
            }
            else if(y > hi){
                perm[j] = temp[x++];
            }
            else if(temp[y] < temp[x]){
                perm[j] = temp[y++];
            }
            else{
                perm[j] = temp[x++];
            }
        }
        return perm;
    }

    public static void sort(Integer[] arr, Integer[] perm, int lo, int hi){
        if(lo < hi){
            int mid = (lo+hi)/2;
            sort(arr, perm, lo, mid);
            sort(arr, perm, mid+1,hi);
            perm = mergeSort(arr, perm, lo, mid, hi);
        }
    }

    // public static void indirectSort(Integer[] arr, Integer[] perm, int lo, int hi){
    //     if(lo < hi){
    //         return;
    //     }
    //     int mid = lo + (hi - lo) / 2;
    //     indirectSort(arr, perm, lo, mid);
    //     indirectSort(arr,perm, mid + 1, hi);
    //     perm = mergeSort(arr, perm, lo, mid, hi);
    // }
  
    public static void print(Integer[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int size = 20;
        Integer[] array = new Integer[size];
        Integer[] perm = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++){
            array[i] = rand.nextInt(1000);
        }  
        print(array);
        // indirectSort(array, perm, 0, size-1);

        print(perm);
    }
}