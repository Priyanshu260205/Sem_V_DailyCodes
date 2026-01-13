class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        double totalArea = 0.0;

        // Find search range and total area
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            low = Math.min(low, y);
            high = Math.max(high, y + l);
            totalArea += l * l;
        }

        double half = totalArea / 2.0;

        // Binary search on y-coordinate
        for (int iter = 0; iter < 60; iter++) {
            double mid = (low + high) / 2.0;
            double areaBelow = 0.0;

            for (int[] sq : squares) {
                double y = sq[1];
                double l = sq[2];

                if (mid > y) {
                    areaBelow += Math.min(mid - y, l) * l;
                }
            }

            if (areaBelow < half) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}