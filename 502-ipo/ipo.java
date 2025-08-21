class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] nums = new int[profits.length][2];
        for(int i=0; i<nums.length; i++){
            nums[i][0] = capital[i];
            nums[i][1] = profits[i];
        }
        Arrays.sort(nums, (a,b)-> a[0]-b[0]);
        return helper(nums, k, w);
    }

    public static int helper(int arr[][], int k, int w){
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0; i<arr.length;){ 
            while (i<arr.length && w >= arr[i][0]) { 
                pq.add(arr[i]); i++; 
            } 
            if(pq.isEmpty() || k==0){ 
                return w; 
            } 
            w += pq.poll()[1]; 
            k--; 
        }
        while(!pq.isEmpty() && k>0){
            w += pq.poll()[1];
            k--;
        } 
        return w; 
    }
}