class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] time = new double[n];

        for (int i = 0; i < n; i++) {
            time[i] = (double) dist[i] / speed[i];
        }

        Arrays.sort(time);

        for (int minute = 0; minute < n; minute++) {
            if (time[minute] <= minute) {
                return minute;
            }
        }

        return n;
    }
}