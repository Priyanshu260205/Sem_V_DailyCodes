class Solution {
    static final int MOD = 1_000_000_007;

    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();

        // Map hat -> people who can wear it
        List<Integer>[] hatToPeople = new ArrayList[41];
        for (int i = 1; i <= 40; i++) {
            hatToPeople[i] = new ArrayList<>();
        }

        for (int person = 0; person < n; person++) {
            for (int hat : hats.get(person)) {
                hatToPeople[hat].add(person);
            }
        }

        int maxMask = 1 << n;
        int[] dp = new int[maxMask];
        dp[0] = 1;

        // Process hats one by one
        for (int hat = 1; hat <= 40; hat++) {
            int[] newDp = dp.clone();

            for (int mask = 0; mask < maxMask; mask++) {
                if (dp[mask] == 0) continue;

                for (int person : hatToPeople[hat]) {
                    if ((mask & (1 << person)) == 0) {
                        int newMask = mask | (1 << person);
                        newDp[newMask] =
                                (newDp[newMask] + dp[mask]) % MOD;
                    }
                }
            }
            dp = newDp;
        }

        return dp[maxMask - 1];
    }
}