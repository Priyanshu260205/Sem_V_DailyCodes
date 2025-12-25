class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;

        for (int i = x; i < nums.size(); i++) {
            // Add element that is now x distance behind
            set.add(nums.get(i - x));

            Integer floor = set.floor(nums.get(i));
            Integer ceil = set.ceiling(nums.get(i));

            if (floor != null)
                ans = Math.min(ans, Math.abs(nums.get(i) - floor));
            if (ceil != null)
                ans = Math.min(ans, Math.abs(nums.get(i) - ceil));
        }

        return ans;
    }
}