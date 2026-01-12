class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        Map<Integer, Integer> evenMap = new HashMap<>();
        Map<Integer, Integer> oddMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenMap.put(nums[i], evenMap.getOrDefault(nums[i], 0) + 1);
            } else {
                oddMap.put(nums[i], oddMap.getOrDefault(nums[i], 0) + 1);
            }
        }

        int[] evenTop = topTwo(evenMap);
        int[] oddTop = topTwo(oddMap);

        // If most frequent values are different
        if (evenTop[0] != oddTop[0]) {
            return n - evenTop[1] - oddTop[1];
        }

        // Otherwise try second best
        int option1 = n - evenTop[1] - oddTop[3];
        int option2 = n - evenTop[3] - oddTop[1];

        return Math.min(option1, option2);
    }

    // returns [value1, freq1, value2, freq2]
    private int[] topTwo(Map<Integer, Integer> map) {
        int v1 = -1, f1 = 0;
        int v2 = -1, f2 = 0;

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq > f1) {
                v2 = v1; f2 = f1;
                v1 = key; f1 = freq;
            } else if (freq > f2) {
                v2 = key; f2 = freq;
            }
        }
        return new int[]{v1, f1, v2, f2};
    }
}