class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i=0; i<n-2; i++){
            if(nums[i] == 0){
                nums[i] = 1;
                nums[i+1] = nums[i+1]^1;
                nums[i+2] = nums[i+2]^1;
                res++;
            }
        }
        for(int i: nums){
            if(i == 0) return -1;
        }
        return res;
    }
}