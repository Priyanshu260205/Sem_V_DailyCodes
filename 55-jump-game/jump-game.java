class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int li = nums.length - 1;
        int max_reach = nums[0];
        for(int i=1; max_reach >= i; i++){
            if(max_reach >= li){
                return true;
            }
            else{
                max_reach = Math.max(max_reach, nums[i] + i);
            }
        }
        return false;
    }
}