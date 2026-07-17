package dsa.binary_search;

import java.util.Arrays;
public class FirstAndLastPositionLS{
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,7,7,8,8,9};
        int target = 7;
        int[] ans = searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] searchRange(int[] arr, int target){

        int[] ans = {-1, -1};

        ans[0] = findFirst(arr, target);
        ans[1] = findLast(arr, target);

        return ans;
    }

    static int findFirst(int[] arr, int target){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    static int findLast(int[] arr, int target){
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
