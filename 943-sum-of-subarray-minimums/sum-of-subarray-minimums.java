class Solution {
    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        int[] left_nxt_sm = find_left_nxt_smaller(arr, len);
        int[] right_nxt_sm = find_right_nxt_smaller(arr, len);
        int mod = 1000000007;
        long total_sum = 0;
        for(int i=0; i<len; i++){
            long left_dis = i - left_nxt_sm[i];
            long right_dis = right_nxt_sm[i] - i;
            long total_ways = left_dis * right_dis;
            long curr_sum = total_ways * arr[i];
            total_sum = (total_sum + curr_sum) % mod;
        }
        return (int) total_sum;
    }
    private int[] find_left_nxt_smaller(int []arr, int len){
        int [] res = new int[len];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<len; i++){
            if(st.isEmpty()){
                res[i] = -1;
            }
            else{
                while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                    st.pop();
                }
                res[i] = (!st.isEmpty()) ? st.peek() : -1;
            }
            st.push(i);
        }
        return res;
    }

    private int[] find_right_nxt_smaller(int []arr, int len){
        int [] res = new int[len];
        Stack<Integer> st = new Stack<>();
        for(int i=len-1; i>=0; i--){
            if(st.isEmpty()){
                res[i] = len;
            }
            else{
                while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                    st.pop();
                }
                res[i] = (!st.isEmpty()) ? st.peek() : len;
            }
            st.push(i);
        }
        return res;
    }
}