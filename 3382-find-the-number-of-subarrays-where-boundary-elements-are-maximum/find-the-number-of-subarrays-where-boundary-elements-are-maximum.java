class Solution {
    public long numberOfSubarrays(int[] nums) {
        Deque<long[]> stack = new ArrayDeque<>();
        long ans = 0;

        for (int x : nums) {
            long cnt = 1;

            while (!stack.isEmpty() && stack.peek()[0] < x) {
                long[] top = stack.pop();
                ans += top[1] * (top[1] + 1) / 2;
            }

            if (!stack.isEmpty() && stack.peek()[0] == x) {
                stack.peek()[1]++;
            } else {
                stack.push(new long[]{x, 1});
            }
        }

        // Remaining elements
        while (!stack.isEmpty()) {
            long[] top = stack.pop();
            ans += top[1] * (top[1] + 1) / 2;
        }

        return ans;
    }
}