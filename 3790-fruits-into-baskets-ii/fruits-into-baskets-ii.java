class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean [] placed_at = new boolean[baskets.length];
        int unplaced = 0;

        for(int i: fruits){
            boolean pace = false;
            for(int j=0; j<baskets.length; j++){
                if(i <= baskets[j] && !placed_at[j]){
                    pace = true;
                    placed_at[j] = true;
                    break;
                }
            }

            if(!pace){
                unplaced++;
            }
        }
        return unplaced;
    }
}