class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> bannedwordsSet = new HashSet<>();
        for(String bannedword : bannedWords){
            bannedwordsSet.add(bannedword);
        }
        int count = 0;
        for(int i=0; i<message.length; i++){
            if(bannedwordsSet.contains(message[i])){
                count++;
            }
            if(count == 2){
                return true;
            }
        }
        return false;
    }
}