class Solution {
    class Pair{
        char e;
        int freq;
        Pair(char el, int freq){
            this.e = el;
            this.freq = freq;
        }
    }
    public String frequencySort(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char i : s.toCharArray()){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        for(char i : map.keySet()){
            pq.offer(new Pair(i, map.get(i)));
        }
        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            Pair r = pq.poll();
            for(int i=0; i<r.freq; i++){
                res.append(r.e);
            }
        }
        return res.toString();
    }
}