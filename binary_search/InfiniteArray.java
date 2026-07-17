package dsa.binary_search;

public class InfiniteArray{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,8,9,11,23,34,78,89,90};
        int target = 11;
        System.out.println(search(arr, target));
    }

    static int search(int[] arr, int target){
        int start = 0;
        int end = 1;

        while(target > arr[end]){
            int newStart = end + 1;
            end = end + (end-start+1)*2;
            start = newStart;
        }
        return binarySearch(arr, target, start, end);
    }
    static int binarySearch(int[] arr, int target, int start, int end){

        while(start <= end){

            int mid = start + (end-start)/2;

            if(target < arr[mid]){
                end = mid - 1;
            }else if(target > arr[mid]){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
