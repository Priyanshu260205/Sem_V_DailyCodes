class Solution {
    public int minLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int dsum = 0;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            map.put(x, map.getOrDefault(x, 0) + 1);
            if(map.get(x) == 1){
                dsum += x;
            }
            while(dsum >= k){
                res = Math.min(res, i-left+1);
                int y = nums[left];
                map.put(y, map.get(y)-1);
                if(map.get(y) == 0){
                    dsum -= y;
                }
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}