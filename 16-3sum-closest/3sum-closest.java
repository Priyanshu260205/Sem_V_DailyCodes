class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res_sum = nums[0] + nums[1] + nums[2];
        int min_difference = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            int low = i+1;
            int high = nums.length-1;

            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if(sum == target){
                    return sum;
                }
                else if(sum < target){
                    low++;
                }
                else{
                    high--;
                }

                int far_from_target = Math.abs(target-sum);
                if(far_from_target < min_difference){
                    res_sum = sum;
                    min_difference = far_from_target;
                }
            }
        }

        return res_sum;
    }
}