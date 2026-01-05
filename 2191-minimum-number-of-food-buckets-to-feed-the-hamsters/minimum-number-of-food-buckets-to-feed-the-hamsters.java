class Solution {
    public int minimumBuckets(String hamsters) {
        int n = hamsters.length();
        char[] arr = hamsters.toCharArray();
        int buckets = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'H') {

                // If already fed by a bucket on the left
                if (i > 0 && arr[i - 1] == 'B') {
                    continue;
                }

                // Try placing bucket on the right
                if (i + 1 < n && arr[i + 1] == '.') {
                    arr[i + 1] = 'B';
                    buckets++;
                }
                // Else try placing bucket on the left
                else if (i > 0 && arr[i - 1] == '.') {
                    arr[i - 1] = 'B';
                    buckets++;
                }
                // No place to put a bucket
                else {
                    return -1;
                }
            }
        }
        return buckets;
    }
}