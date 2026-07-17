package dsa.arrays;

import java.util.Arrays;

public class Swap {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Before swap:");
        System.out.println(Arrays.toString(arr));

        System.out.println("After swap:");
        reverse(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void reverse(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    static void swap(int[] arr, int num1, int num2){
        int temp = arr[num1];
        arr[num1] =  arr[num2];
        arr[num2] = temp;
    }
}
