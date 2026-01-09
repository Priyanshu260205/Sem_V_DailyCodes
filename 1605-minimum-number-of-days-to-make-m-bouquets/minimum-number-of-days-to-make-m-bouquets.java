class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m*k > n) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i : bloomDay){
            low = Math.min(i, low);
            high = Math.max(i, high);
        }
        int ans = -1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(bloomDay, mid, m, k)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] bloomDay, int day, int m, int k){
        int f = 0;
        int b = 0;
        for(int i : bloomDay){
            if(i <= day){
                f++;
                if(f == k){
                    b++;
                    f=0;
                }
            }
            else{
                f=0;
            }
        }

        return b >= m;
    }
}