class Solution {
    public int countBeautifulPairs(int[] nums) {
        int[] count = new int[10];
        int ans = 0;

        for (int num : nums) {
            int last = num % 10;

            // Count valid pairs with previous numbers
            for (int d = 1; d <= 9; d++) {
                if (count[d] > 0 && gcd(d, last) == 1) {
                    ans += count[d];
                }
            }

            // Update frequency of first digit
            int first = getFirstDigit(num);
            count[first]++;
        }
        return ans;
    }

    private int getFirstDigit(int num) {
        while (num >= 10) num /= 10;
        return num;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}