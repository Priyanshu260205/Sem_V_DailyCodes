class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        long count = 0;

        for(int n: nums){
            if(n == 0){
                count += 1;
                res += count;
            }
            else{
                count = 0;
            }
        }

        return res;
    }
}