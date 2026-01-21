class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor1 = bitwise_xor(arr1);
        int xor2 = bitwise_xor(arr2);
        return xor1 & xor2;
    }

    public int bitwise_xor(int[] nums){
        int res = 0;
        for(int i : nums){
            res ^= i;
        }
        return res;
    }
}