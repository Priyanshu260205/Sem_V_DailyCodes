class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words)
            map.put(w, map.getOrDefault(w, 0) + 1);

        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {
                if (map.get(a).equals(map.get(b))) {
                    return b.compareTo(a); // reverse lexicographical
                }
                return map.get(a) - map.get(b); // smaller freq first
            }
        );

        for (String word : map.keySet()) {
            pq.add(word);
            if (pq.size() > k) pq.poll(); // keep only top k
        }

        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) res.add(pq.poll());

        Collections.reverse(res); // because we used a min-heap
        return res;
    }
}
