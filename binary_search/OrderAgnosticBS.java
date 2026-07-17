package dsa.binary_search;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] array = {1,2,4,6,8,10,23,25,28,90};
        int[] array2 = {90,28,13,12,11,9,8,6,3,2,0,-12,-19};
        int target = 0;
        int ans = orderAgnosticBS(array2, target);
        System.out.println("Target found at index: " + ans);
    }

    /**
     * Performs binary search on either an ascending or descending sorted array.
     *
     * @param arr sorted array (ascending or descending)
     * @param target value to search for
     * @return index of target if found, otherwise -1
     */
    static int orderAgnosticBS(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            int mid = start + (end-start)/2;

            if(target == arr[mid]){
                return mid;
            }
            if(isAsc){
                if(target > arr[mid]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            else{
                if(target > arr[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }

            }
        }
        return -1;
    }
}
