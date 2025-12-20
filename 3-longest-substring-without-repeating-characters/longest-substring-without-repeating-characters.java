class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int left = 0;
        int right = s.length()-1;
        int maxlen = 0;

        for(int i=0; i<=right; i++){
            char c = s.charAt(i);

            while(hs.contains(c)){
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(c);
            maxlen = Math.max(maxlen, i-left+1);
        }
        return maxlen;
    }
}