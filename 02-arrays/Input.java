import java.util.Arrays;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        System.out.println("This is the Input class in the dsa.arrays package.");

        Scanner in = new Scanner(System.in);

        // Creating and initializing an array. array of primitives.
        /*int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;*/
        //System.out.println(arr[3]);

        //input using for loop.
        /*System.out.println("Enter " + arr.length + " elements: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = in.nextInt();
        }*/

        //There are multiple ways to print an array.
        //1. Using for loop.
       /* for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }*/

        //2. Using for-each loop.
       /* for(int num : arr){
            System.out.print(num + " ");
        }*/

        //3. Using Arrays.toString() method.
        //System.out.println(Arrays.toString(arr));

        //array of objects.
        String[] str = new String[4];
        System.out.println("Enter " + str.length + " names: ");
        for(int i=0; i< str.length; i++) {
            str[i] = in.next();
        }
        System.out.println(Arrays.toString(str));
        //modify
        str[1] = "Shyam";
        System.out.println(Arrays.toString(str));

    }
}
