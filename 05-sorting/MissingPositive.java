// https://leetcode.com/problems/first-missing-positive/

public class MissingPositive {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        firstMissingPositive(nums);
        System.out.println(firstMissingPositive(nums));
    }

    static int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int cIndex = nums[i] - 1;
            if(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[cIndex]){
                swap(nums, i, cIndex);
            }else{
                i++;
            }
        }
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index + 1){
                return index + 1;
            }
        }
        return nums.length + 1;
    }

    static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
