class Solution {
    public int largestPrime(int n) {
        if (n < 2) return 0;

        boolean[] isPrime = sieve(n);

        int sum = 0;
        int result = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                sum += i;
                if (sum > n) break;
                if (isPrime[sum]) {
                    result = sum;
                }
            }
        }

        return result;
    }

    private boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                isPrime[i] = true;
            }

            for (int i = 2; i * i <= n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return isPrime;
    }
}