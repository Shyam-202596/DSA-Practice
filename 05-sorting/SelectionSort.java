import java.util.Arrays;

public class SelectionSort{
    public static void main(String[] arg){

        int[] arr = {5, 4, 1, 2, 3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void selectionSort(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            int last = n-i-1;
            int maxIndex = findMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }

    static int findMaxIndex(int[] arr, int start, int last){
        int maxIndex = start;

        for(int i = 0; i <= last; i++){
            if(arr[maxIndex] < arr[i]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static void swap(int[] arr, int maxIndex, int last){
        int temp = arr[last];
        arr[last] = arr[maxIndex];
        arr[maxIndex] = temp;
    }
}
