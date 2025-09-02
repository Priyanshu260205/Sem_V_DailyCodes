class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxdistance = 0;
        int minsof = arrays.get(0).get(0);
        int maxsof = arrays.get(0).get(arrays.get(0).size() - 1);
        for(int i=1; i<arrays.size(); i++){
            int currmin = arrays.get(i).get(0);
            int currmax = arrays.get(i).get(arrays.get(i).size()-1);

            maxdistance = Math.max(maxdistance, maxsof-currmin);
            maxdistance = Math.max(maxdistance, currmax-minsof);

            minsof = Math.min(minsof, currmin);
            maxsof = Math.max(maxsof, currmax);
        }
        return maxdistance;
    }
}