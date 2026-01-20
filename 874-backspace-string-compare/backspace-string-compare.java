class Solution {
    public boolean backspaceCompare(String s, String t) {
        String res1 = resultant(s);
        String res2 = resultant(t);

        return res1.equals(res2);
    }

    public String resultant(String s){
        Stack<Character> st = new Stack<>();
        String res = "";
        for(char i: s.toCharArray()){
            if(i != '#') st.push(i);
            else{
                if(!st.isEmpty()) st.pop();
            }
        }

        while(!st.isEmpty()){
            res += st.pop();
        }
        return res;
    }
}