class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winners = new HashSet<>();
        Map<Integer, Integer> losers = new HashMap<>();
        for(int[] match: matches){
            losers.put(match[1], losers.getOrDefault(match[1], 0) + 1);
        }
        for(int[] match : matches){
            if(!losers.containsKey(match[0])){
                winners.add(match[0]);
            }
        }
        List<Integer> winners_li = new ArrayList<>(winners);
        List<Integer> losers_li = new ArrayList<>();
        for(int loser: losers.keySet()){
            if(losers.get(loser) == 1){
                losers_li.add(loser);
            }
        }
        Collections.sort(winners_li);
        Collections.sort(losers_li);
        List<List<Integer>> res = new ArrayList<>();
        res.add(winners_li);
        res.add(losers_li);
        return res;
    }
}