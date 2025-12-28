class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        Deque<Integer> dq = new ArrayDeque<>();
        long sumRunning = 0;
        int ans = 0;

        for (int l = 0, r = 0; r < n; r++) {
            // add r
            sumRunning += runningCosts[r];
            while (!dq.isEmpty() && chargeTimes[dq.peekLast()] <= chargeTimes[r]) {
                dq.pollLast();
            }
            dq.offerLast(r);

            // shrink while over budget
            while (!dq.isEmpty()) {
                long maxCharge = chargeTimes[dq.peekFirst()];
                int len = r - l + 1;
                long cost = maxCharge + (long) len * sumRunning;
                if (cost <= budget) break;

                // remove l
                if (dq.peekFirst() == l) dq.pollFirst();
                sumRunning -= runningCosts[l];
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}