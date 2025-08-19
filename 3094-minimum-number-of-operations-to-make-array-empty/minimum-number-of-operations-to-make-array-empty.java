class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }
            else{
                hm.put(nums[i], 1);
            }
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            int val = entry.getValue();
            if(val == 1){
                return -1;
            }
            else{
                if(val % 3 == 0){
                    count += val / 3;
                }
                else if(val % 3 == 1 || val % 3 == 2){
                    count += ((val/3) + 1);
                }
                else if(val % 2 == 0){
                    count += val / 2;
                }
                else{
                    return -1;
                }
            }
        }
        return count;
    }
}