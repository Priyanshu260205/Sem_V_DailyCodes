class Solution {
    public int countPrimes(int n) {
        int res_count = 0;
        if(n <= 2){
            return 0;
        }
        boolean []composites = new boolean[n];
        int limit = (int)Math.sqrt(n);
        for(int i=2; i<=limit; i++){
            if(composites[i] == false){
                for(int j=i*i; j<n; j += i){
                    composites[j] = true;
                }
            }
        }
        for(int i=2; i<n; i++){
            if(composites[i] == false) res_count++;
        }

        return res_count;
    }
}