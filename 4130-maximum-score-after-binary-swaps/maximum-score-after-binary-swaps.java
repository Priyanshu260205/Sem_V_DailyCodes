class Solution {
    public long maximumScore(int[] nums, String s) {
        int n = nums.length;
        long totalScore = 0;
        PriorityQueue<Integer> availableValues = new PriorityQueue<>(Collections.reverseOrder());
        boolean zeroSeen = false;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeroSeen = true;
                availableValues.add(nums[i]);
            } else {
                if (!zeroSeen) {
                    totalScore += nums[i];
                } else {
                    availableValues.add(nums[i]);
                    totalScore += availableValues.poll();
                }
            }
        }
        
        return totalScore;
    }
}