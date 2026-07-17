package dsa.binary_search;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

public class RotationBS{
    public static void main(String[] args){

        int[] arr = {5, 6, 7, 8, 9, 10, 11, 1, 2, 3,4};
        //System.out.println("Pivot: " + findPivot(arr));
        int target = 4;
        System.out.println(search(arr, target));

    }

    static int search(int[] arr, int target){

        int pivot = findPivot(arr);

        if(pivot == -1){
            return binarySearch(arr, target, 0, arr.length-1);
        }

        if(target == arr[pivot]){
            return pivot;
        }

        if(target >= arr[0]){
            return binarySearch(arr, target, 0, pivot-1);
        }

        return binarySearch(arr, target, pivot+1, arr.length-1);
    }

    static int binarySearch(int[] arr, int target, int start, int end){

        while(start <= end){

            int mid = start + (end-start)/2;

            if(target > arr[mid]){
                start = mid+1;
            }else if(target < arr[mid]){
                end = mid-1;
            }else{
                //ans found
                return mid;
            }
        }
        return -1;
    }

    // this will not work in duplicate values
    static int findPivot(int[] arr){

        int start = 0;
        int end = arr.length-1;

        while(start <= end){

            int mid = start + (end-start)/2;

            if(mid > start && arr[mid] < arr[mid-1]){
                return mid-1;
            }
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(arr[start] > arr[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
}
