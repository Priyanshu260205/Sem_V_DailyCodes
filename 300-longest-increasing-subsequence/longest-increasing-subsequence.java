class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS(nums);
    }

    public int LIS(int [] arr){
        int dp[] = new int[arr.length];
        int len = 1;
        dp[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > dp[len-1]){
                dp[len] = arr[i];
                len++;
            }
            else{
                int idx = BinarySearch(dp, 0, len-1, arr[i]);
                dp[idx] = arr[i];
            }
        }
        return len;
    }

    public int BinarySearch(int[] dp, int left, int right, int target){
        int idx = 0;
        while(left <= right){
            int mid = left + (right-left)/2;

            if(dp[mid] >= target){
                idx = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return idx;
    }
}