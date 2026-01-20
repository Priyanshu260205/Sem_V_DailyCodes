class MinStack {
    Stack<Integer> st;
    Stack<Integer> mins;
    public MinStack() {
        st = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(mins.isEmpty() || mins.peek() >= val){
            mins.push(val);
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            int v = st.pop();
            if(!mins.isEmpty() && mins.peek() == v) mins.pop();
        }
    }
    
    public int top() {
        if(!st.isEmpty()){
            return st.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if(!mins.isEmpty()){
            return mins.peek();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */