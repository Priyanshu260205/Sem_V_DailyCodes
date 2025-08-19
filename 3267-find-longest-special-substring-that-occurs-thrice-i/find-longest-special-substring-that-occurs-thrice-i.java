class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> hm = new HashMap();
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                String str = s.substring(i, j);
                if(hm.containsKey(str)){
                    hm.put(str, hm.get(str) + 1);
                }
                else{
                    hm.put(str, 1);
                }
            }
        }
        int len = 0;
        for(Map.Entry<String, Integer> entry : hm.entrySet()){
            String str = entry.getKey();
            int string_c = entry.getValue();
            if(string_c >= 3){
                Set<Character> set = new HashSet();
                for(int j=0; j<str.length(); j++){
                    set.add(str.charAt(j));
                }
                if(set.size() == 1){
                    len = Math.max(len, str.length());
                }
            }
        }
        return (len == 0) ? -1 : len;
    }
}