class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] pref = new long[n];
        pref[0] = nums[0];

        for(int i=1; i<n; i++){
            pref[i] = pref[i-1] + nums[i];
        }

        long res = Long.MIN_VALUE;
        for(int i=0; i<k; i++){
            long currsum = 0;
            int j = i;
            while(j < n && j+k-1 < n){
                int x = j + k - 1;
                long sub_sum = pref[x] - ((j>0) ? pref[j-1] : 0);

                currsum = Math.max(sub_sum, currsum + sub_sum);
                res = Math.max(res , currsum);

                j += k;
            }
        }
        return res;
    }
}