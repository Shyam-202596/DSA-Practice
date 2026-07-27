import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args){

        int[] arr = {5, 3, 1, 2, 4};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void cyclicSort(int[] arr){
        int n = arr.length;
        int i = 0;
        while(i < n){
            //find correct index
            int correctIndex = arr[i] - 1;

            //if element are not at correct index then swap with correct index.
            if(arr[correctIndex] != arr[i]){
                swap(arr, correctIndex, i);
            }else{
                i++;
            }
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
