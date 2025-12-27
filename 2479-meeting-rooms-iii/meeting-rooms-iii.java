class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Available rooms (smallest index first)
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            available.offer(i);
        }

        // Busy rooms: [endTime, roomIndex]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        long[] count = new long[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // Free rooms that have finished
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.offer((int) busy.poll()[1]);
            }

            if (!available.isEmpty()) {
                int room = available.poll();
                busy.offer(new long[]{end, room});
                count[room]++;
            } else {
                // Delay meeting
                long[] top = busy.poll();
                long newEnd = top[0] + duration;
                busy.offer(new long[]{newEnd, top[1]});
                count[(int) top[1]]++;
            }
        }

        // Find room with max meetings
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[res]) {
                res = i;
            }
        }
        return res;
    }
}