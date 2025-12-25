class Solution {
    public int countBinaryPalindromes(long n) {
        if (n == 0) return 1;

        int count = 1; // for "0"
        int len = 64 - Long.numberOfLeadingZeros(n);

        // Count palindromes with smaller bit lengths
        for (int L = 1; L < len; L++) {
            int half = (L + 1) / 2;
            count += 1 << (half - 1);
        }

        // Count palindromes of same length
        int half = (len + 1) / 2;

        long prefix = n >> (len - half);
        long base = 1L << (half - 1);

        count += prefix - base;

        // Check if the palindrome formed by prefix ≤ n
        long pal = buildPalindrome(prefix, len % 2 == 1);
        if (pal <= n) count++;

        return count;
    }

    private long buildPalindrome(long x, boolean odd) {
        long res = x;
        if (odd) x >>= 1;

        while (x > 0) {
            res = (res << 1) | (x & 1);
            x >>= 1;
        }
        return res;
    }
}