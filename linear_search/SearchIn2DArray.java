package dsa.linear_search;

import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {23, 4, 1},
                {18, 12, 3, 89},
                {78, 99, 34},
                {56, 90}
        };
        int target = 99;
        int[] result = search(arr, target);
        System.out.println(Arrays.toString(result));
        System.out.println(max(arr));
    }

    /**
     * Searches the 2D array for target and returns its position as {row, col}.
     * Returns {-1, -1} when the target is not present.
     */
    static int[] search(int[][] arr, int target){
        for(int row=0; row < arr.length; row++){
            for(int col=0; col < arr[row].length; col++){
                if(target == arr[row][col]) return new int[]{row,col};
            }
        }

        return new int[]{-1,-1};
    }

    /**
     * Returns the largest value found in the 2D array.
     * Initializes with Integer.MIN_VALUE to support negative numbers.
     */
    static int max(int[][] arr){
        int max = Integer.MIN_VALUE;
        for(int[] row: arr){
            for(int col : row){
                if(col>max) max = col;
            }
        }
        return max;
    }
}
