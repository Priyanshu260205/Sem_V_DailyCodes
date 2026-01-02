class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] scores = new long[n];

        for (int i = 0; i < n; i++) {
            int destination = edges[i];
            scores[destination] += i;
        }

        int resultNode = 0;
        long maxScore = -1;

        for (int i = 0; i < n; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                resultNode = i;
            }
        }

        return resultNode;
    }
}