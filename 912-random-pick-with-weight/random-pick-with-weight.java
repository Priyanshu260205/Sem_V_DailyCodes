class Solution {
    int[] prefix;
    int total;
    Random rand = new Random();

    public Solution(int[] w) {
        prefix = new int[w.length];
        prefix[0] = w[0];
        for(int i=1; i<w.length; i++){
            prefix[i] = prefix[i-1] + w[i];
        }
        total = prefix[prefix.length-1];
    }
    
    public int pickIndex() {
        int r = rand.nextInt(total) + 1;
        int l = 0, right = prefix.length-1;
        while(l < right){
            int mid = l + (right-l)/2;
            if(prefix[mid] >= r){
                right = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */