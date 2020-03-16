// Nicholas Harris
// harris.nicholas1998@gmail.com

/* Fast 3-way partitioning. (J. Bentley and D. Mcllroy) Implement an entropy-optimal sort based on
keeping item's with equal keys at both the left and right ends of the subarray. Maintain indices p
and q such that a[lo..p-1] and a[q+1..hi] are all equal to a[lo], an index i such that a[p..i-1] are
all less than a[lo], and an index j such that a[j+1..q] are all greater than a[lo]. Add to the inner
partitioning loop code to swap a[i] with a[p] (and increment p) if it is equal to v and to swap a[j]
with a[q] (and decrement q) if it is equal to v before the usual comparisons of a[i] and a[j]
with v. After the partitioning loop has terminated, add code to swap the items with equal keys
into position.
Note : This code complements the code given in the text, in the sense that it does extra swaps for
keys equal to the partitioning item’s key, while the code in the text does extra swaps for keys that
are not equal to the partitioning item’s key */

import java.util.Random;

public class A2Q5 {
    public static boolean hasPrinted = false;

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a){
        return isSorted(a,0,a.length-1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi){
        for(int i = lo + 1; i <= hi; i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    private static void print(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void sort(Comparable[] a){    
        fastSort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    public static void fastSort(Comparable[] a, int lo, int hi){
        if(hi <= lo){
            return;
        }
        int p = lo;
        int q = hi+1;
        int i = lo;
        int j = hi+1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i],v)){
                if(i == hi){
                    break;
                }
            }
            while(less(v,a[--j])){
                if(j == lo){
                    break;
                }
            }
            if(i == j && a[i].compareTo(v) == 0){
                exch(a, ++p, i);
            }
            if(i >= j){
                break;
            }
            exch(a,i,j);
            if(a[i].compareTo(v) == 0){
                exch(a, ++p, i);
            }
            if(a[j].compareTo(v) == 0){
                exch(a, --q, j);
            }
        }

        if(!hasPrinted){
            System.out.print("Phase 1 of quick3way sort: ");
            print(a);
            hasPrinted = true;
        }
        i = j + 1;
        for(int k = p; k >= lo; k--){
            exch(a,k,j--);
        }
        for(int k = q; k <= hi; k++){
            exch(a,k,i++);
        }
        fastSort(a,lo,j);
        fastSort(a, i, hi);
        assert isSorted(a,lo,hi);
    }
  

    public static void main(String[] args){
        Random rand = new Random();
        // Comparable[] array = {11, 0,2,3,5,11,11,12,32,18,15,19,4,11,7,20,11};
        Integer[] array = new Integer[30];
        for(int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(10);
        }
        System.out.print("Orig array: ");
        print(array);
        sort(array);
        System.out.print("Sorted array: ");
        print(array);
    }
}