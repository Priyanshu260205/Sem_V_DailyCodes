class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            int x1 = bottomLeft[i][0];
            int y1 = bottomLeft[i][1];
            int x2 = topRight[i][0];
            int y2 = topRight[i][1];

            for (int j = i + 1; j < n; j++) {
                int x3 = bottomLeft[j][0];
                int y3 = bottomLeft[j][1];
                int x4 = topRight[j][0];
                int y4 = topRight[j][1];

                int left   = Math.max(x1, x3);
                int bottom = Math.max(y1, y3);
                int right  = Math.min(x2, x4);
                int top    = Math.min(y2, y4);

                if (right > left && top > bottom) {
                    long side = Math.min(right - left, top - bottom);
                    maxArea = Math.max(maxArea, side * side);
                }
            }
        }

        return maxArea;
    }
}