class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        char a = pattern.charAt(0);
        char b = pattern.charAt(1);

        long countA = 0;
        long countB = 0;
        long base = 0;

        // Count existing subsequences and total a, b
        for (char c : text.toCharArray()) {
            if (c == b) {
                base += countA;
                countB++;
            }
            if (c == a) {
                countA++;
            }
        }

        // If both characters are same
        if (a == b) {
            long n = countA + 1; // after insertion
            return n * (n - 1) / 2;
        }

        // Two choices: insert a or insert b
        long insertA = base + countB;
        long insertB = base + countA;

        return Math.max(insertA, insertB);        
    }
}