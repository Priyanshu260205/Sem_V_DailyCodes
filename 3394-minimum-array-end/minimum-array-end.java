class Solution {
    public long minEnd(int n, int x) {
        long result = x;
        long add = n - 1;
        int bit = 0;

        while (add > 0) {
            // If current bit in x is 0, we can place bits from add
            if ((x & (1L << bit)) == 0) {
                if ((add & 1) == 1) {
                    result |= (1L << bit);
                }
                add >>= 1;
            }
            bit++;
        }
        return result;
    }
}