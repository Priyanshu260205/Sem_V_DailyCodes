class Solution {
    public int maxLength(List<String> arr) {
        List<String> res = new ArrayList<>();
        res.add("");
        for(int i=0; i<arr.size(); i++){
            String str = arr.get(i);
            if(!hasUniqueChars(str)){
                continue;
            }
            List<String> currlist = new ArrayList<>();
            for(String s : res){
                StringBuilder sb = new StringBuilder();
                sb.append(s).append(str);
                if(hasUniqueChars(sb.toString())){
                    currlist.add(sb.toString());
                }
            }
            res.addAll(currlist);
        }
        int maxlen = 0;
        for(String str: res){
            int currlen = str.length();
            if(currlen>maxlen){
                maxlen = currlen;
            }
        }
        return maxlen;
    }
    private boolean hasUniqueChars(String str){
        boolean[] visited = new boolean[26];
        for(char ch: str.toCharArray()){
            if(visited[ch-'a']){
                return false;
            }
            else{
                visited[ch-'a'] = true;
            }
        }
        return true;
    }
}