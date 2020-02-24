//Nicholas Harris
//harris.nicholas1998@gmail.com

public class A2Q1 {

    public static void evenOddArrange(int[] arr, int k){
        if(k == 0){
            return;
        }
        else if(arr[k]%2 == 0){
            for(int i = 0; i < k ; i++){
                if(arr[i]%2 == 1){
                    swap(arr, i, k);
                    evenOddArrange(arr, k - 1);
                }
            }
        }
        else{
            evenOddArrange(arr, k - 1);
        }
    }

    public static void swap(int[] arr, int i, int k){
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }

    public static void main(String[] args){
        int[] array = {2,3,4,5,6,7,8};
        System.out.print("Original Array: ");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        evenOddArrange(array, array.length - 1);
        System.out.print("\nRearranged Array: ");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}