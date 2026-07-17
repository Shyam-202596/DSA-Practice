package dsa.binary_search;

// https://leetcode.com/problems/split-array-largest-sum/

public class SplitArray{
    public static void main(String[] args){
        int[] arr = {7,2,5,10,8};
        //int[] arr = {1,2,3,4,5};
        int m = 2;
        System.out.println(splitArray(arr, m));
    }

    static int splitArray(int[] nums, int m){
        int start = 0;
        int end = 0;

        for(int i=0; i<nums.length; i++){
            start = Math.max(start, nums[i]); // in the end of the loop this will contain the max item of the array
            end += nums[i];
        }

        while(start < end){
            // try for the middle as potential ans
            int mid = start + (end-start)/2;

            // calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;
            for(int num : nums){
                if(sum + num > mid){
                    // you cannot add this in this subarray, make new one
                    // say you add this num in new subarray, then sum = num
                    sum = num;
                    pieces++;
                }else{
                    sum += num;
                }
            }

            if(pieces <= m){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return end; // here start == end
    }
}
