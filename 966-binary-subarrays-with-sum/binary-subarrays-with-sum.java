class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
                return helper(nums, goal) - helper(nums, goal - 1);
    }
    public int helper(int nums[],int goal) {
        if (goal < 0) {
            return 0;
        }
        int count = 0, sum = 0;
        int start = 0, end = 0;
        while (start < nums.length) {
            sum += nums[start]; 
            while (end < nums.length && sum > goal) {
                sum -= nums[end];
                end++;
            }
            count += start - end + 1;
            start++;
        }
        return count;
    }
}