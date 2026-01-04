class Solution {
    public int maxProfit(int[] prices) {
        int miniso = Integer.MAX_VALUE;
        int maxiso = 0;

        for(int i : prices){
            if(i < miniso){
                miniso = i;
            }
            else{
                maxiso = Math.max(maxiso, i - miniso);
            }
        }

        return maxiso;
    }
}