class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        // dp[i][j] will be true if s[i...j] is a palindrome
        boolean[][] dp = new boolean[n][n];

        // We iterate through lengths (len 1 to n) or backward from i
        // to ensure dp[i+1][j-1] is always calculated before dp[i][j].
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // Check if characters at boundaries match
                if (s.charAt(i) == s.charAt(j)) {
                    // Check if the gap is small (length <= 3) 
                    // OR if the inner substring is a palindrome
                    if (j - i <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}