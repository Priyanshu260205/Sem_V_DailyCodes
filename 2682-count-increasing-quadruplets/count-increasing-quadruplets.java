class Solution {
    public long countQuadruplets(int[] nums) {
        int n=nums.length;
        long[] dp=new long[n];
        Arrays.fill(dp,0);
        long ret=0;
        for(int i=1;i<n;i++)
        {
            int choice=0;
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    choice++;
                    ret+=dp[j];
                }
                else if(nums[i]<nums[j])
                {
                    dp[j]+=choice;
                }
            }
        }
        return ret;
    }
}