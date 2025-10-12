public class Solution {
    private static final int MOD = 1_000_000_007;

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;

        // Precompute binomial coefficients C[0..m][0..m]
        long[][] C = new long[m + 1][m + 1];
        for (int i = 0; i <= m; ++i) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; ++j) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }

        // Precompute powNum[j][c] = nums[j]^c % MOD for c = 0..m
        long[][] powNum = new long[n][m + 1];
        for (int j = 0; j < n; ++j) {
            powNum[j][0] = 1;
            long base = (nums[j] % MOD + MOD) % MOD;
            for (int c = 1; c <= m; ++c) {
                powNum[j][c] = (powNum[j][c - 1] * base) % MOD;
            }
        }

        // DP: cur[used][pop][carry] = sum(product) % MOD
        long[][][] cur = new long[m + 1][k + 1][m + 1];
        cur[0][0][0] = 1;

        for (int j = 0; j < n; ++j) {
            long[][][] next = new long[m + 1][k + 1][m + 1];
            for (int used = 0; used <= m; ++used) {
                for (int pop = 0; pop <= k; ++pop) {
                    for (int carry = 0; carry <= m; ++carry) {
                        long val = cur[used][pop][carry];
                        if (val == 0) continue;

                        for (int c = 0; c <= m - used; ++c) {
                            int newUsed = used + c;
                            int total = carry + c;
                            int bit = total & 1;
                            int newPop = pop + bit;
                            if (newPop > k) continue;
                            int newCarry = total >> 1;
                            long ways = (val * C[m - used][c]) % MOD;
                            long contrib = (ways * powNum[j][c]) % MOD;

                            next[newUsed][newPop][newCarry] += contrib;
                            if (next[newUsed][newPop][newCarry] >= MOD)
                                next[newUsed][newPop][newCarry] -= MOD;
                        }
                    }
                }
            }
            cur = next;
        }

        long ans = 0;
        for (int pop = 0; pop <= k; ++pop) {
            for (int carry = 0; carry <= m; ++carry) {
                long val = cur[m][pop][carry];
                if (val == 0) continue;
                int carryPop = Integer.bitCount(carry);
                if (pop + carryPop == k) {
                    ans += val;
                    if (ans >= MOD) ans -= MOD;
                }
            }
        }

        return (int) ans;
    }
}
