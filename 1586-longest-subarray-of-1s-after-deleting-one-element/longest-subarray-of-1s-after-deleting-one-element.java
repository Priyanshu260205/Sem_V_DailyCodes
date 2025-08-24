class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        boolean isDel = false;
        int ans = 0;

        while(right < nums.length){
            int n = nums[right];
            if(n == 1){
                ans = isDel ? Math.max(ans, right-left) : Math.max(ans, right-left+1);
            }
            else{
                if(isDel){
                    while(nums[left] == 1){
                        left += 1;
                    }
                    left += 1;
                }
                else{
                    isDel = true;
                }
            }
            right += 1;
        }
        return isDel ? ans : ans-1;

    }
}