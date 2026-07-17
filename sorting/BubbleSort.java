package dsa.sorting;

import java.util.Arrays;
public class BubbleSort{
    public static void main(String[] args){

        int[] arr = {5, 3, 4, 1, 2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void bubbleSort(int[] arr){
        int n = arr.length;

        boolean swapped;

        // run the steps n-1 times
        for(int i = 0; i < n; i++){
            swapped = false;
            // for each step, max item will come at the last respective index
            for(int j = 1; j < n-i; j++){
                // swap if the item is smaller than the previous item
                if(arr[j] < arr[j-1]){
                    //swap;
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
}
