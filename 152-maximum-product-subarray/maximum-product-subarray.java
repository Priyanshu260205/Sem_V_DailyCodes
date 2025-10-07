class Solution {
    public int maxProduct(int[] nums) {
        int min_sofar = nums[0];
        int max_sofar = nums[0];
        int res = nums[0];

        for(int i=1; i<nums.length; i++){
            int curr = nums[i];
            if(curr < 0){
                int temp = min_sofar;
                min_sofar = max_sofar;
                max_sofar = temp;
            }

            min_sofar = Math.min(curr, min_sofar * curr);
            max_sofar = Math.max(curr, max_sofar * curr);

            res = Math.max(res, max_sofar);
        }

        return res;
    }
}