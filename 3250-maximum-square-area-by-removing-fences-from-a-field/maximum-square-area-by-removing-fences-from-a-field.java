class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] h = addBoundaries(hFences, m);
        int[] v = addBoundaries(vFences, n);
        
        // Store all possible horizontal gaps in a HashSet for O(1) lookup
        Set<Integer> hGaps = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                hGaps.add(Math.abs(h[i] - h[j]));
            }
        }
        
        long maxSide = -1;
        // Check all possible vertical gaps
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int gap = Math.abs(v[i] - v[j]);
                // If this gap also exists horizontally, it can form a square
                if (hGaps.contains(gap)) {
                    maxSide = Math.max(maxSide, gap);
                }
            }
        }
        
        if (maxSide == -1) return -1;
        
        // Use modulo as required by the problem for large areas
        long mod = 1_000_000_007;
        return (int) ((maxSide * maxSide) % mod);
    }
    
    private int[] addBoundaries(int[] fences, int limit) {
        int[] result = new int[fences.length + 2];
        for (int i = 0; i < fences.length; i++) result[i] = fences[i];
        result[fences.length] = 1;
        result[fences.length + 1] = limit;
        return result;
    }
}