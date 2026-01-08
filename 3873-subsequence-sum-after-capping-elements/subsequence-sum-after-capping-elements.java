class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        boolean[] answer = new boolean[n];
        
        // Count frequencies of each number
        int[] freq = new int[n + 1];
        for (int num : nums) freq[num]++;
        
        // We use BitSet for O(K/64) subset sum updates
        BitSet dp = new BitSet(k + 1);
        dp.set(0);
        
        // 'greaterCount' tracks how many numbers are >= current x
        int greaterCount = n; 
        
        for (int x = 1; x <= n; x++) {
            // Elements that are exactly x-1 now "lock in" their value
            // and no longer change as x increases.
            if (x > 1) {
                int countOfPrevX = freq[x - 1];
                // Add these 'locked' items to our base DP
                for (int i = 0; i < countOfPrevX; i++) {
                    // Optimized: add items one by one or via binary splitting
                    updateBitSet(dp, x - 1, k);
                }
                greaterCount -= countOfPrevX;
            }
            
            // Now we need to check if we can reach k using:
            // 1. The base DP (all items < x)
            // 2. 'greaterCount' number of items that are currently capped at x
            
            // Temporary DP to include current capped items
            BitSet currentDP = (BitSet) dp.clone();
            
            // Use binary splitting to add 'greaterCount' items of value 'x'
            int tempCount = greaterCount;
            for (int m = 1; tempCount > 0; m <<= 1) {
                int numItems = Math.min(m, tempCount);
                int totalVal = numItems * x;
                if (totalVal <= k) {
                    // Shift the bitset to represent adding 'totalVal'
                    BitSet shifted = currentDP.get(0, k + 1 - totalVal);
                    // Use a temporary bitset to avoid modifying while shifting
                    BitSet next = new BitSet(k + 1);
                    for (int bit = currentDP.nextSetBit(0); bit >= 0 && bit + totalVal <= k; bit = currentDP.nextSetBit(bit + 1)) {
                        next.set(bit + totalVal);
                    }
                    currentDP.or(next);
                }
                tempCount -= numItems;
            }
            
            answer[x - 1] = currentDP.get(k);
        }
        
        return answer;
    }

    private void updateBitSet(BitSet dp, int val, int k) {
        if (val > k) return;
        for (int i = k; i >= val; i--) {
            if (dp.get(i - val)) dp.set(i);
        }
    }
}