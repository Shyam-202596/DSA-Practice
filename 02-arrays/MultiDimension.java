import java.util.Arrays;
import java.util.Scanner;

public class MultiDimension {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //declare a 2D array.
        //int[][] arr = new int[3][];

        /*int[][] arr = {
                {1, 2, 3},
                {3, 4},
                {8, 9, 2}
        }; */

        int[][] arr = new int[3][3];
        System.out.println(arr.length); //number of rows.

        //input
        for(int row=0; row<arr.length; row++){
            // for each col in every row
            for(int col=0; col<arr[row].length; col++){
                arr[row][col] = in.nextInt();
            }
        }

        //output
        /*for(int row=0; row<arr.length; row++){
            // for each col in every row
            for(int col=0; col<arr[row].length; col++){
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }*/

        //output.
        /*for(int row=0; row<arr.length; row++){
            System.out.println(Arrays.toString(arr[row]));
        }*/
        //output using for-each loop.
        for(int[] a:arr){
            System.out.println(Arrays.toString(a));
        }
    }
}
