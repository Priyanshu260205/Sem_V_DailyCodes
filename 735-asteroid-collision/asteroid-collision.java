class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<Integer>();

        for(int i : asteroids){
            boolean destroyed = false;
            while(!st.isEmpty() && st.peek() > 0 && i < 0){
                int t = st.peek();
                if(Math.abs(i) > t){
                    st.pop();
                    continue;
                }
                else if(Math.abs(i) == t){
                    st.pop();
                    destroyed = true;
                    break;
                }
                else{
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed){
                st.push(i);
            }
        }

        int[] res = new int[st.size()];
        for(int i=st.size()-1; i>=0; i--){
            res[i] = st.pop();
        }

        return res;
    }
}