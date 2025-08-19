class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap();
        int count = 0;
        for(int i=0; i<nums.length; i++){
            int target = k - nums[i];
            if(hm.containsKey(target)){
                count++;
                if(hm.get(target) == 1){
                    hm.remove(target);
                }
                else{
                    hm.put(target, hm.get(target) - 1);
                }
            }
            else{
                hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }
}