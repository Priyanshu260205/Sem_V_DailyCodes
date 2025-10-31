class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int[] res = new int[2];
        int c = 0;
        for(int i: map.keySet()){
            if(map.get(i) > 1){
                res[c] = i;
                c++;
            }
        }

        return res;
    }
}