class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(String s, int start, List<String> path, List<List<String>> res){
        if(start == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=start ;i<s.length(); i++){
            if(isPalindrome(s.substring(start, i+1))){
                path.add(s.substring(start, i+1));
                backtrack(s, i+1, path, res);
                path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalindrome(String sc){
        int start = 0;
        int end = sc.length()-1;

        while(start < end){
            if(!(sc.charAt(start++) == sc.charAt(end--))){
                return false;
            }
        }
        return true;
    }
}