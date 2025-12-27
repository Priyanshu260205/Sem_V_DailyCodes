class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        Map<Integer, Integer> freq = new HashMap<>();
        Deque<int[]> kept = new ArrayDeque<>(); // {dayIndex, itemType}
        int discarded = 0;

        for (int i = 0; i < arrivals.length; i++) {
            int day = i + 1;
            int type = arrivals[i];

            // Remove items that are out of the window
            while (!kept.isEmpty() && kept.peekFirst()[0] < day - w + 1) {
                int oldType = kept.pollFirst()[1];
                freq.put(oldType, freq.get(oldType) - 1);
            }

            // Check if we can keep today's arrival
            int count = freq.getOrDefault(type, 0);
            if (count == m) {
                // Must discard
                discarded++;
            } else {
                // Keep it
                freq.put(type, count + 1);
                kept.offerLast(new int[]{day, type});
            }
        }

        return discarded;
    }
}