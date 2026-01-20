class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int d = 0;

        for(char i : s.toCharArray()){
            if(i == '('){
                if(d>0) sb.append(i);
                d++;
            }
            else{
                d--;
                if(d > 0) sb.append(i);
            }
        }

        return sb.toString();
    }
}