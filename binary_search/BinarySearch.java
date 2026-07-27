public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1,2,4,6,8,10,23,25,28,90};
        int target = 28;
        int ans = binarySearch(array,target);
        System.out.println("Target found at index: " + ans);
    }
    /**
     * Performs binary search on a sorted array to find the target value.
     * @param arr the sorted array to search in
     * @param target the value to search for
     * @return the index of target if found, otherwise -1
     */
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){

            int mid = start + (end-start)/2;

            if(target > arr[mid]){
                start = mid+1;
            }else if(target < arr[mid]){
                end = mid-1;
            }
            else {
                //terget found
                return mid;
            }
        }
        return -1;
    }
}
