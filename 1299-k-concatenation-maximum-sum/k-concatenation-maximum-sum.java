class Solution {
    static final int MOD = 1_000_000_007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        long kadane = maxSubarray(arr);
        if (k == 1) return (int)(kadane % MOD);

        long prefix = maxPrefix(arr);
        long suffix = maxSuffix(arr);
        long total = 0;
        for (int x : arr) total += x;

        long result;
        if (total > 0) {
            result = Math.max(
                kadane,
                suffix + prefix + (k - 2) * total
            );
        } else {
            result = Math.max(
                kadane,
                suffix + prefix
            );
        }

        return (int)(result % MOD);
    }

    private long maxSubarray(int[] arr) {
        long max = 0, curr = 0;
        for (int x : arr) {
            curr = Math.max(x, curr + x);
            max = Math.max(max, curr);
        }
        return max;
    }

    private long maxPrefix(int[] arr) {
        long sum = 0, max = 0;
        for (int x : arr) {
            sum += x;
            max = Math.max(max, sum);
        }
        return max;
    }

    private long maxSuffix(int[] arr) {
        long sum = 0, max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}