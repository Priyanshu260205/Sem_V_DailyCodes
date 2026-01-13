class Solution {
    public int minOperations(int n, int m) {
        if (isPrime(n) || isPrime(m)) return -1;

        int max = 10000; // constraint upper bound
        long[] dist = new long[max];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{n, n}); // {cost, value}
        dist[n] = n;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long cost = cur[0];
            int val = (int) cur[1];

            if (val == m) return (int) cost;
            if (cost > dist[val]) continue;

            char[] digits = String.valueOf(val).toCharArray();
            for (int i = 0; i < digits.length; i++) {
                char original = digits[i];

                // Increase digit
                if (digits[i] < '9') {
                    digits[i]++;
                    int next = Integer.parseInt(new String(digits));
                    if (!isPrime(next) && dist[next] > cost + next) {
                        dist[next] = cost + next;
                        pq.offer(new long[]{dist[next], next});
                    }
                }

                // Decrease digit
                digits[i] = original;
                if (digits[i] > '0') {
                    digits[i]--;
                    int next = Integer.parseInt(new String(digits));
                    if (!isPrime(next) && dist[next] > cost + next) {
                        dist[next] = cost + next;
                        pq.offer(new long[]{dist[next], next});
                    }
                }

                digits[i] = original;
            }
        }

        return -1;
    }

    private boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}