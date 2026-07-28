public class FindDuplicate {
    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 2};
        findDuplicate(nums);
        System.out.println(findDuplicate(nums));
    }
    static int findDuplicate(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int cIndex = nums[i] - 1;
            if(nums[cIndex] != nums[i]){
                swap(nums, cIndex, i);
            }else{
                i++;
            }
        }
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index + 1){
                return nums[index];
            }
        }
        return -1;
    }
    static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
