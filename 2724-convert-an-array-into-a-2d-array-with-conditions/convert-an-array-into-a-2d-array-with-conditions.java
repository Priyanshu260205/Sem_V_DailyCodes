class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int freq[] = new int[nums.length + 1];
        for(int i=0; i<nums.length; i++){
            if(freq[nums[i]] >= res.size()){
                res.add(new ArrayList<>());
            }
            res.get(freq[nums[i]]).add(nums[i]);
            freq[nums[i]]++;
        }
        return res;
    }
}