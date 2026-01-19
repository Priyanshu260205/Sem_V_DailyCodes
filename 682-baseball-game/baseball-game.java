class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(String i : operations){
            if(i.equals("+")){
                int r = st.pop();
                int e = r + st.peek();
                st.push(r);
                st.push(e);
            }
            else if(i.equals("D")){
                st.push(st.peek()*2);
            }
            else if(i.equals("C")){
                st.pop();
            }
            else{
                st.push(Integer.parseInt(i));
            }
        }

        int sum = 0;
        while(!st.isEmpty()){
            sum += st.pop();
        }
        return sum;
    }
}