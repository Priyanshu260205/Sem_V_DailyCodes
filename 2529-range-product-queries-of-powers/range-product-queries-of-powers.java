class Solution {
    private long MOD = 1_000_000_007L;
    public int[] productQueries(int n, int[][] queries) {
        
        List<Long> powers = new ArrayList<>();

        for(int i=0; i<32; i++){
            if(((n >> i) & 1) == 1){
                powers.add(1L << i);
            }
        }

        long[] prefix = new long[powers.size()];
        prefix[0] = powers.get(0) % MOD;
        for(int i=1; i<powers.size(); i++){
            prefix[i] = (prefix[i-1] * (powers.get(i) % MOD)) % MOD;
        }
        
        int [] ans = new int[queries.length];
        for(int q=0; q<queries.length; q++){
            int l = queries[q][0];
            int r = queries[q][1];

            if(l == 0){
                ans[q] = (int) prefix[r];
            }
            else{
                long b = prefix[r];
                long c = prefix[l-1];
                long inv = modInverse(c, MOD-2);
                ans[q] = (int) ((b * inv) % MOD);
            }
        }

        return ans;
    }

    private long modInverse(long base, long exponent){
        long res = 1;
        while(exponent > 0){
            if((exponent & 1) == 1){
                res = (res*base) % MOD;
            }
            base = (base * base) % MOD;
            exponent = exponent >> 1;
        }

        return res;
    }
}