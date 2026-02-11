class Solution {
    static final long mod = 1000000007;
    static long[] fact = new long[805];
    static long[] ifact = new long[805];
    public int countKReducibleNumbers(String s, int k) {
        int n = s.length();
        fact[0] = 1;
        ifact[0] = 1;
        for(int i=1; i<801; i++) {
            fact[i] = (fact[i-1] * i) % mod;
        }
        ifact[800] = power(fact[800], mod-2, mod);
        for(int i=799; i>0; i--) {
            ifact[i] = (ifact[i+1]*(i+1)) % mod;
        }
        long[] ans = new long[801];
        Arrays.fill(ans, -1);
        ans[1] = 0;
        for(int i=2; i<801; i++) {
            int cnt = 0;
            int x = i;
            while(x > 0) {
                if((x & 1) == 1) cnt++;
                x /= 2;
            }
            ans[i] = ans[cnt] + 1;
        }
        long res = 0;
        for(long i=1; i<=n; i++) {
            long val = i;
            if(ans[(int) i] <= k-1) {
                for(long j=0; j<n; j++) {
                    if(s.charAt((int) j) == '1') {
                        long rem = n - j - 1;
                        if(rem < val - 1) break;
                        if(rem >= val) res = (res + bin(rem, val)) % mod;
                        val--;
                        if(val < 1) {
                            res++;
                            res %= mod;
                            break;
                        }
                    }
                }
            }
        }
        int tot = 0;
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '1') tot++;
        }
        if(ans[tot] <= k-1) res--;
        res += mod;
        res %= mod;
        return (int) res;
    }
    private static long power(long x, long y, long z) {
        long ans = 1;
        x %= z;
        if(x == 0) return 0;
        while(y > 0) {
            if((y & 1) == 1) ans = (ans * x) % z;
            y >>= 1;
            x = (x * x) % z;
        }
        return ans;
    }
    private static long bin(long a, long b) {
        if(a < b) return 0;
        return ((fact[(int) a] * ifact[(int) (a-b)] % mod) * ifact[(int) b]) % mod;
    }
}