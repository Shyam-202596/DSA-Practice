public class FindMin {
    public static void main(String[] args) {
        int[] numbers = {18, 12, 9, 14, 77, 50,-19,20};
        int result = findMin(numbers);
        System.out.println(result);
    }
    
    /**
     * Returns the smallest value in the given integer array.
     * Assumes the array is non-empty.
     */
    private static int findMin(int[] arr) {
        int min = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}
