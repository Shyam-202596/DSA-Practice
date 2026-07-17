package dsa.linear_search;

public class FindMax {
    public static void main(String[] args) {
        int[] numbers = {18, 12, 9, 14, 77, 50,-19,20};
        int result = findMax(numbers);
        System.out.println(result);
    }

    /**
     * Returns the largest value in the given integer array.
     * Assumes the array is non-empty.
     */
    private static int findMax(int[] arr) {
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
