class Solution {
    public int numDecodings(String s) {
        int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1; // Base case: empty string has 1 way
    dp[1] = s.charAt(0) == '0' ? 0 : 1;

    for (int i = 2; i <= n; i++) {
        // Check single digit
        int oneDigit = Integer.parseInt(s.substring(i - 1, i));
        if (oneDigit >= 1) {
            dp[i] += dp[i - 1];
        }

        // Check two digits
        int twoDigits = Integer.parseInt(s.substring(i - 2, i));
        if (twoDigits >= 10 && twoDigits <= 26) {
            dp[i] += dp[i - 2];
        }
    }
    return dp[n];
    }
}