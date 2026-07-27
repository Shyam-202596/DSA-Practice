public class SearchInRange {
    public static void main(String[] args) {
        int[] nums = {11, 23, 45, 65, 12, -3, -88, 0, 44};
        int target = 12;
        int result = linearSearch(nums, target, 1,4);
        System.out.println(result);
    }

    /**
     * Searches for target in the array between start and end indices (inclusive).
     * Returns the index if found, otherwise returns -1.
     */
    static int linearSearch(int[] arr, int target, int start, int end){
        if(arr.length == 0) return -1;

        for(int index = start; index<= end; index++){
            int element = arr[index];
            if(element == target) return index;
        }

        return -1;
    }
}
