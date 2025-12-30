class Solution {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String, Double> day1Amts = getMaxAmounts(initialCurrency, 1.0, pairs1, rates1);
        
        double maxFinalAmount = 1.0; // Minimum is starting amount (do nothing)

        // For each currency we could hold after Day 1, find how to get back to initial on Day 2
        for (Map.Entry<String, Double> entry : day1Amts.entrySet()) {
            String intermediateCurr = entry.getKey();
            double amountAfterDay1 = entry.getValue();
            
            // Search on Day 2 graph starting from the intermediate currency
            Map<String, Double> day2Return = getMaxAmounts(intermediateCurr, amountAfterDay1, pairs2, rates2);
            
            if (day2Return.containsKey(initialCurrency)) {
                maxFinalAmount = Math.max(maxFinalAmount, day2Return.get(initialCurrency));
            }
        }

        return maxFinalAmount;
    }

    private Map<String, Double> getMaxAmounts(String startNode, double startAmount, List<List<String>> pairs, double[] rates) {
        Map<String, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            String u = pairs.get(i).get(0);
            String v = pairs.get(i).get(1);
            double r = rates[i];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Node(v, r));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Node(u, 1.0 / r));
        }

        Map<String, Double> maxAmts = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        
        maxAmts.put(startNode, startAmount);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (!graph.containsKey(curr)) continue;

            for (Node neighbor : graph.get(curr)) {
                double newAmt = maxAmts.get(curr) * neighbor.rate;
                if (newAmt > maxAmts.getOrDefault(neighbor.name, 0.0)) {
                    maxAmts.put(neighbor.name, newAmt);
                    queue.add(neighbor.name);
                }
            }
        }
        return maxAmts;
    }

    class Node {
        String name;
        double rate;
        Node(String n, double r) { name = n; rate = r; }
    }
}