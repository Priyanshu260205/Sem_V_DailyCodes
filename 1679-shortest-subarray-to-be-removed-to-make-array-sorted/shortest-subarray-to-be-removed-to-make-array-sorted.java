class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Step 1: find longest non-decreasing prefix
        int l = 0;
        while (l + 1 < n && arr[l] <= arr[l + 1]) {
            l++;
        }
        if (l == n - 1) return 0; // already sorted

        // Step 2: find longest non-decreasing suffix
        int r = n - 1;
        while (r > 0 && arr[r - 1] <= arr[r]) {
            r--;
        }

        // Step 3: base answer
        int ans = Math.min(n - l - 1, r);

        // Step 4: merge prefix and suffix
        int i = 0, j = r;
        while (i <= l && j < n) {
            if (arr[i] <= arr[j]) {
                ans = Math.min(ans, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
}