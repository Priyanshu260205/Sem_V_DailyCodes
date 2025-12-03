class Solution {
    class Pair{
        int score;
        int index;
        Pair(int score, int index){
            this.score = score;
            this.index = index;
        }
    }
    public String[] findRelativeRanks(int[] score) {
        String[] res = new String[score.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.score - b.score);


        for(int i=0; i<score.length; i++){
            pq.offer(new Pair(score[i], i));
        }
        int rank = pq.size();
        while(!pq.isEmpty()){
            Pair r = pq.poll();
            if(rank == 1){
                res[r.index] = "Gold Medal";
            }
            else if(rank == 2){
                res[r.index] = "Silver Medal";
            }
            else if(rank == 3){
                res[r.index] = "Bronze Medal";
            }
            else{
                res[r.index] = ""+rank;
            }
            rank--;
        }
        return res;
    }
}