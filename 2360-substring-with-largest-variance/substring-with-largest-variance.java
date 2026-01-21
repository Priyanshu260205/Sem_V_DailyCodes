class Solution {
    public int largestVariance(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        int ans = 0;

        for (int a = 0; a < 26; a++) {
            for (int b = 0; b < 26; b++) {
                if (a == b || freq[a] == 0 || freq[b] == 0) continue;

                char ca = (char) (a + 'a');
                char cb = (char) (b + 'a');

                ans = Math.max(ans, kadane(s, ca, cb));
                ans = Math.max(ans, kadane(new StringBuilder(s).reverse().toString(), ca, cb));
            }
        }
        return ans;
    }

    private int kadane(String s, char a, char b) {
        int diff = 0;
        int remainingB = 0;
        for (char c : s.toCharArray()) if (c == b) remainingB++;

        boolean hasB = false;
        int best = 0;

        for (char c : s.toCharArray()) {
            if (c == a) diff++;
            if (c == b) {
                diff--;
                remainingB--;
                hasB = true;
            }

            if (hasB) best = Math.max(best, diff);

            if (diff < 0 && remainingB > 0) {
                diff = 0;
                hasB = false;
            }
        }
        return best;
    }
}