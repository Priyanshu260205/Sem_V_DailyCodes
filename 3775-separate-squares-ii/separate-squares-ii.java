class Solution {
    static class Event{
        double y;
        int type; // +1 enter, -1 exit
        int x1, x2;

        Event(double y, int type, int x1, int x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    public double separateSquares(int[][] squares) {
        int n = squares.length;

        List<Integer> xs = new ArrayList<>();
        List<Event> events = new ArrayList<>();

        for (int[] s : squares) {
            int x1 = s[0];
            int y1 = s[1];
            int l = s[2];
            int x2 = x1 + l;
            int y2 = y1 + l;

            xs.add(x1);
            xs.add(x2);

            events.add(new Event(y1, +1, x1, x2));
            events.add(new Event(y2, -1, x1, x2));
        }

        // Coordinate compression
        Collections.sort(xs);
        Map<Integer, Integer> xId = new HashMap<>();
        for (int i = 0; i < xs.size(); i++) {
            xId.put(xs.get(i), i);
        }

        events.sort(Comparator.comparingDouble(e -> e.y));

        SegmentTree st = new SegmentTree(xs);

        double totalArea = 0;
        double prevY = events.get(0).y;

        // First pass: compute total union area
        for (Event e : events) {
            double dy = e.y - prevY;
            totalArea += st.coveredLength() * dy;

            st.update(xId.get(e.x1), xId.get(e.x2), e.type);
            prevY = e.y;
        }

        double half = totalArea / 2.0;

        // Second pass: find y where cumulative area reaches half
        st.clear();
        prevY = events.get(0).y;
        double curArea = 0;

        for (Event e : events) {
            double dy = e.y - prevY;
            double slab = st.coveredLength() * dy;

            if (curArea + slab >= half) {
                double remain = half - curArea;
                return prevY + remain / st.coveredLength();
            }

            curArea += slab;
            st.update(xId.get(e.x1), xId.get(e.x2), e.type);
            prevY = e.y;
        }

        return prevY;
    }

    // Segment Tree for union length
    static class SegmentTree {
        int n;
        int[] count;
        double[] length;
        List<Integer> xs;

        SegmentTree(List<Integer> xs) {
            this.xs = xs;
            this.n = xs.size() - 1;
            count = new int[4 * n];
            length = new double[4 * n];
        }

        void clear() {
            Arrays.fill(count, 0);
            Arrays.fill(length, 0);
        }

        void update(int l, int r, int val) {
            update(1, 0, n, l, r, val);
        }

        void update(int node, int start, int end, int l, int r, int val) {
            if (r <= start || end <= l) return;
            if (l <= start && end <= r) {
                count[node] += val;
            } else {
                int mid = (start + end) / 2;
                update(node * 2, start, mid, l, r, val);
                update(node * 2 + 1, mid, end, l, r, val);
            }

            if (count[node] > 0) {
                length[node] = xs.get(end) - xs.get(start);
            } else if (start + 1 == end) {
                length[node] = 0;
            } else {
                length[node] = length[node * 2] + length[node * 2 + 1];
            }
        }

        double coveredLength() {
            return length[1];
        }
    }
}