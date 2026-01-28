class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int[] memo=new int[boxes.length];
        int weight=0, left=0, right=0, lastDiffCity=-1, trips=0;
        while(right<boxes.length) {
            weight+=boxes[right][1];
            while(weight>maxWeight||right-left+1>maxBoxes||
                (left>0&&left<right&&memo[left]==memo[left-1])) { 
                if(boxes[left][0]!=boxes[left+1][0]) trips--;
                weight-=boxes[left++][1];
            }
            if((right==0||boxes[right-1][0]!=boxes[right][0]))
                trips++;
            memo[right++]=left==0?trips:memo[left-1]+1+trips;
        }
        return memo[memo.length-1]+1;
    }
}