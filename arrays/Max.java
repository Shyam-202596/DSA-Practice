package dsa.arrays;

public class Max {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 9, 87, 8};

        int max = findMax(arr);
        System.out.println("The maximum value in the array is: " + max);

        int maxInRange = maxRange(arr, 1, 3);
        System.out.println("The maximum value in the range 1 to 3 is: " + maxInRange);
    }

    static int maxRange(int[] arr, int start, int end) {
        //handling edge cases
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        if (start < 0 || end >= arr.length || start > end) {
            throw new IllegalArgumentException("Invalid start or end indices");
        }
        //finding max in the specified range
        int maxValue = arr[start];
        for (int i = start; i <= end; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    static int findMax(int[] arr) {
        //handling edge cases
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("Array is null or empty");
        }
        //finding max
        int max = arr[0];
        for (int i = 1; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
}
