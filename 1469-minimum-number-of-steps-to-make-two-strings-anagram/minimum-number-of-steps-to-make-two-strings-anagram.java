class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch) + 1);
            }
            else{
                hm.put(ch, 1);
            }
        }
        int count = 0;
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(hm.containsKey(ch) && hm.get(ch) > 0){
                hm.put(ch, hm.get(ch) - 1);
            }
            else{
                count++;
            }
        }
        return count++;

    }
}