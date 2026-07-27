public class LinearSearch {
    public static void main(String[] args) {
       int[] nums = {18, 12, 9, 14, 77, 50,-19,20}; //
       int target = 50;
       int result = linearSearch(nums, target);
       System.out.println(result);
    }

    //2. fine whether target element exists in array or not? if exists return true else return false.
    private static boolean linearSearch2(int[] arr, int target) {
        if(arr.length==0) return false;
        for(int elements:arr){
            if(elements == target) return true;
        }
        return false;
    }

    //1. fine whether target element exists in array or not? if exists return index else return -1.
    private static int linearSearch(int[] arr, int target) {
        if(arr.length == 0){
            return -1;
        }
        for(int index=0; index<arr.length; index++){
            int element = arr[index];
            if(element==target){
                return index;
            }
        }
        return -1;
    }
}
