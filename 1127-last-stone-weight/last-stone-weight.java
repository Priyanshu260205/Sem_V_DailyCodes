class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int x : stones){
            pq.offer(x);
        }
        while(pq.size() > 1){
            int p1 = pq.poll();
            int p2 = pq.poll();
            if(p1 != p2){
                pq.offer(p1 - p2);
            }
        }
        if(pq.size() > 0){
            return pq.peek();
        }
        return 0;
    }
}