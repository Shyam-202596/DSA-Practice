package dsa.binary_search;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args){
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(search(arr, 9)));
    }

    static int[] search(int[][] arr, int target){
        int r = 0;
        int c = arr[0].length-1;

        while(r < arr.length && c >= 0){

            if(target == arr[r][c]){
                return new int[] {r, c};
            }

            if(target > arr[r][c]){
                r++;
            }else{
                c--;
            }
        }
        return new int[] {-1, -1};
    }
}
