class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Preprocess
        StringBuilder sb = new StringBuilder("^");
        for (char c : s.toCharArray()) {
            sb.append("#").append(c);
        }
        sb.append("#$");
        char[] arr = sb.toString().toCharArray();

        int n = arr.length;
        int[] p = new int[n]; // palindrome radius
        int center = 0, right = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // expand
            while (arr[i + p[i] + 1] == arr[i - p[i] - 1]) {
                p[i]++;
            }

            // update center & right
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        // find max palindrome
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}