class Solution {
    public int subsetXORSum(int[] nums) {
        int or = 0;
        for (int x : nums) {
            or |= x;
        }
        return or * (1 << (nums.length - 1));
    }
}