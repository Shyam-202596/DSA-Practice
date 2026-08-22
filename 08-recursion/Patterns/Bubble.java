public class Bubble {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        bubble(arr, 4, 0);
    }
    static void bubble(int[] arr, int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r-1) {
            if(arr[c] > arr[c + 1]){
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }
            bubble(arr, r, c + 1);
        } else {
            bubble(arr, r - 1, 0);
        }
    }
}
