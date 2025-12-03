class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0){
            return res;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]+a[1]) - (b[0]+b[1]));
        for(int i=0; i<Math.min(nums1.length, k); i++){
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while(k-- > 0 && !pq.isEmpty()){
            int[] r = pq.poll();
            res.add(Arrays.asList(r[0], r[1]));
            if(r[2]+1 < nums2.length){
                pq.offer(new int[]{r[0], nums2[r[2]+1], r[2]+1});
            }
        }
        return res;
    }
}
    // class Pair{
    //     int e1;
    //     int e2;
    //     int sum;
    //     Pair(int e1, int e2){
    //         this.e1 = e1;
    //         this.e2 = e2;
    //         this.sum = e1 + e2;
    //     }
    // }