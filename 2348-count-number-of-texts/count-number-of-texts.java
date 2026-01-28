class Solution {
    int MOD = 1000000007;
    String key;
    Integer[] dp;
    int[] count;
	
    private int solve(int i) {
	
        if(i >= key.length())
            return 1;
        
        if(dp[i] != null) 
            return dp[i];
       
        char first = key.charAt(i);
        int res = 0, cnt = 1, mxCnt = count[first - '0'], j = i;
        
        while(i < key.length() && key.charAt(i) == first && cnt <= mxCnt) {
            res = (((res%MOD) + (solve(i+1)%MOD)) % MOD);
            i++; cnt++;
        }
		
        return dp[j] = res;
    }
	
    public int countTexts(String pressedKeys) {
	
        this.key = pressedKeys;
        this.count = new int[]{0,0,3,3,3,3,3,4,3,4};
        this.dp = new Integer[pressedKeys.length()+1];
        return solve(0);
		
    }
}