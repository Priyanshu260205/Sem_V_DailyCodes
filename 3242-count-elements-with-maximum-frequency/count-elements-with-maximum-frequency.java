class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max_freq = 0;
        for(int i: nums){
            int get = map.getOrDefault(i, 0) + 1;
            map.put(i, get);
            max_freq = Math.max(max_freq, get);
        }

        int res = 0;
        for(int i: map.values()){
            if(i == max_freq){
                res += i;
            }
        }
        return res ;
    }
}