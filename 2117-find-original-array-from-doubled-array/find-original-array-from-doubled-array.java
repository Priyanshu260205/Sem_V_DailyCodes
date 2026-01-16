class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[0];

        Arrays.sort(changed);
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : changed) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int[] res = new int[n / 2];
        int idx = 0;

        for (int x : changed) {
            if (map.get(x) == 0) continue;

            int doubleVal = x * 2;
            if (x == 0) {
                if (map.get(0) < 2) return new int[0];
            }

            if (map.getOrDefault(doubleVal, 0) > 0) {
                res[idx++] = x;
                map.put(x, map.get(x) - 1);
                map.put(doubleVal, map.get(doubleVal) - 1);
            } else {
                return new int[0];
            }
        }

        return res;
    }
}