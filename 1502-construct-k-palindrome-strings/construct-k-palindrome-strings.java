class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k){
            return false;
        }
        if(s.length() == k){
            return true;
        }
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        int oddcount = 0;
        for(int n: freq){
            if(n % 2 == 1){
                oddcount++;
            }
        }
        return oddcount <= k;
    }
}