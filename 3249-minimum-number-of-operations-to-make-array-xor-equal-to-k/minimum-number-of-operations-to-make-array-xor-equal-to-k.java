class Solution {
    public int minOperations(int[] nums, int k) {
        int x_or = nums[0];
        for(int i=1; i<nums.length; i++){
            x_or ^= nums[i];
        }
        if(x_or == k){
            return 0;
        }
        return countOperations(x_or, k);
    }

    public int countOperations(int x, int y){
        int diff_bits = 0;
        for(int i=0; i<32; i++){
            int x_lsb = ((x >> i) & 1);
            int y_lsb = ((y >> i) & 1);
            if(x_lsb != y_lsb){
                diff_bits++;
            }
        }
        return diff_bits;
    }
}