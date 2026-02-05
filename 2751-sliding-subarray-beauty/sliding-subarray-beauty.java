class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;

         int [] arr = new int[50];
         int [] res = new int[n-k+1];

         for(int i=0 ; i<n ; i++){
             if(nums[i]<0)arr[nums[i]+50]++;
             if(i-k>=0 && nums[i-k]<0)arr[nums[i-k]+50]--;
             if(i-k+1<0)continue;

             for(int j=0 , count=0 ; j<50 ;j++){
                 count += arr[j];
                 if(count>=x){
                    res[i-k+1] = j-50;
                    break;
                 }
             }

         }
         return res;
    }
}