class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length-1;

        while(i >= 2){
            if(nums[i-2]+nums[i-1] > nums[i]){
                return nums[i-2]+nums[i-1]+nums[i];
            }
            i--;
        }
        return 0;
    }
}