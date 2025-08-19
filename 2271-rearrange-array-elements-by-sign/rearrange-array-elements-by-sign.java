class Solution {
    public int[] rearrangeArray(int[] nums) {
        int res[] = new int[nums.length];
        int pos_idx = 0, neg_idx = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                res[pos_idx] = nums[i];
                pos_idx = pos_idx + 2;
            }
            else{
                res[neg_idx] = nums[i];
                neg_idx = neg_idx + 2;
            }
        }
        return res;
    }
}