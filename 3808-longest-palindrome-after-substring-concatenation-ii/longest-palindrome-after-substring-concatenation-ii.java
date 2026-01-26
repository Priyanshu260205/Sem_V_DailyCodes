class Solution {
    public int longestPalindrome(String s, String t) {
        int n = s.length();  
        int m = t.length();  
        int maxLength = 0;  
        int[][] dp = new int[n+1][m+1];
        int[] p = new int[n+1];
        for (int i = 0; i < n; i++) {
            for(int j = n-1; j >= 0; j--) {
                if(isPal(s, i, j)) {  
                    p[i] = j - i + 1;  
                    break;
                }
            }
        }

        int[] q = new int[m+1];
        for (int i = 0; i < m; i++) {
            for(int j = 0; j <= i; j++) {
                if(isPal(t, j, i)) { 
                    q[i+1] = i - j + 1; 
                    break;
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            dp[n][i] = q[i]; 
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = p[i]; 
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i) == t.charAt(j - 1)) {
                    dp[i][j] = Math.max(p[i], q[j]);
                    dp[i][j] = Math.max(dp[i][j], 2 + dp[i + 1][j - 1]);
                } else {
                    dp[i][j] = Math.max(p[i], q[j]);
                }
                
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }
    private boolean isPal(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}