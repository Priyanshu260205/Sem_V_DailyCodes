class Solution {
    public int findMaximumLength(int[] nums) {
        int n = nums.length;
        int[] queue = new int[n + 1];  // Queue to track indices
        int writeIndex = 0;  // Pointer for writing to the queue
        int readIndex = 0;   // Pointer for reading from the queue
        long[] prefixSum = new long[n + 1];  // Prefix sums of the array
        long[] maxSums = new long[n + 1];  // Array to store the maximum sums
        int[] maxLength = new int[n + 1];  // Array to store the maximum lengths

        // Compute prefix sums
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];

            while (readIndex < writeIndex && prefixSum[i] >= maxSums[readIndex + 1]) {
                readIndex++;
            }
            int bestIndex = queue[readIndex];
            long subarraySum = prefixSum[i] - prefixSum[bestIndex];
            maxLength[i] = maxLength[bestIndex] + 1;
            long newSum = prefixSum[i] + subarraySum;

            while (newSum <= maxSums[writeIndex]) {
                writeIndex--;
            }
            queue[++writeIndex] = i;
            maxSums[writeIndex] = newSum;
        }
        return maxLength[n];
    }
}