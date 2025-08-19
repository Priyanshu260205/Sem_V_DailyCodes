class Solution {
    public int getWinner(int[] arr, int k) {
        Queue<Integer> q = new LinkedList<>();
        int max_e = arr[0];
        for(int i=1; i<arr.length; i++){
            max_e = Math.max(max_e, arr[i]);
            q.offer(arr[i]);
        }
        int curr = arr[0];
        int win_streak = 0;
        while(!q.isEmpty()){
            int opp = q.poll();
            if(curr > opp){
                q.offer(opp);
                win_streak++;
            }
            else{
                q.offer(curr);
                curr = opp;
                win_streak = 1;
            }
            if(win_streak == k || curr == max_e){
                return curr;
            }
        }
        return -1;
    }
}