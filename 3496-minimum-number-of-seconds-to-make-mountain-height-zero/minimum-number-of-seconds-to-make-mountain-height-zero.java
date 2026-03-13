class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long maxT = 0;
        for (int t : workerTimes) 
            maxT = Math.max(maxT, t);

        long n = workerTimes.length;
        long v = (mountainHeight + n - 1) / n;
        
        long start = 0;
        long end = maxT * v * (v + 1) / 2;
        long res = end;
        
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (canFinish(mountainHeight, workerTimes, mid)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    private boolean canFinish(int targetHeight, int[] workerTimes, long mid) {
        long totalHeight = 0;
        for (int t : workerTimes) {
            long x = (long) ((-1 + Math.sqrt(1 + 8.0 * mid / t)) / 2.0);
            totalHeight += x;
            if (totalHeight >= targetHeight) 
                return true;
        }
        return totalHeight >= targetHeight;

    }
}