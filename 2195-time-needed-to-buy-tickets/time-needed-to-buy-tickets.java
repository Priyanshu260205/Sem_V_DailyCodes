class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        int res = 0;
        for(int i=0; i<tickets.length; i++){
            q.add(i);
        }

        while(!q.isEmpty()){
            res++;
            int re = q.poll();
            tickets[re]--;
            if(tickets[re] != 0){
                q.add(re);
            }
            else{
                if(re == k){
                    return res;
                }
            }
        }
        return res;
    }
}