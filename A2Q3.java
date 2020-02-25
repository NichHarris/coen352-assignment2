// Nicholas Harris
// harris.nicholas1998@gmail.com

/* Indirect sort. Develop and implement a version of mergesort that does not re-arrange the
array, but returns an int[] array perm such that perm [i] is the index of the ith smallest 
entry in the array. */

import java.util.Random;

public class A2Q3 {

    public static void mergeSort(Integer[] arr, Integer[] perm, Integer[] temp, int lo, int mid, int hi){
        // Integer[] temp = new Integer[arr.length];
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++){
            temp[k] = perm[k];
        }

        for(int k = lo; k <= hi; k++){
            if(i > mid){
                perm[k] = temp[j++];
            }
            else if(j > hi){
                perm[k] = temp[i++];
            }
            else if(arr[temp[j]] < arr[temp[i]]){
                perm[k] = temp[j++];
            }
            else{
                perm[k] = temp[i++];
            }
        }
    }

    public static Integer[] sort(Integer[] arr){
        Integer[] perm = new Integer[arr.length];
        Integer[] temp = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++){
            perm[i] = i;
        }
        indirectSort(arr, perm, temp, 0, arr.length - 1);
        return perm;
    }

    public static void indirectSort(Integer[] arr, Integer[] perm, Integer[] temp, int lo, int hi){
        if(hi <= lo){
            return;
        }
        int mid = lo + (hi - lo)/2;
        indirectSort(arr, perm, temp, lo, mid);
        indirectSort(arr, perm, temp, mid + 1, hi);
        mergeSort(arr, perm, temp, lo, mid, hi);
    }
  
    public static void print(Integer[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int size = 20;
        Integer[] array = new Integer[size];
        Integer[] newArray = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++){
            array[i] = rand.nextInt(1000);
        }  
        System.out.print("Orig array: ");
        print(array);
        newArray = sort(array);
        System.out.print("perm array: ");
        print(newArray);
    }
}