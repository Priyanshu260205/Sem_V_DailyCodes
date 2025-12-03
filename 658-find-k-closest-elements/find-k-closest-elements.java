class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int da = Math.abs(x-a);
            int db = Math.abs(x-b);
            if(da == db) return b - a;
            return db - da;
        });
        for(int i : arr){
            pq.offer(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        ArrayList<Integer> res = new ArrayList<>(pq);
        Collections.sort(res);
        return res;
    }
}