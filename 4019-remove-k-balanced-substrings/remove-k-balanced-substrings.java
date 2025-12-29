class Solution {
    public String removeSubstring(String s, int k) {
        java.util.Deque<int[]> stack = new java.util.ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            // Merge consecutive same characters
            if (!stack.isEmpty() && stack.peek()[0] == ch) {
                stack.peek()[1]++;
            } else {
                stack.push(new int[]{ch, 1});
            }

            // Check and remove k-balanced substrings
            while (stack.size() >= 2) {
                int[] close = stack.pop(); // ')'
                int[] open  = stack.pop(); // '('

                if (open[0] == '(' && close[0] == ')' &&
                    open[1] >= k && close[1] >= k) {

                    open[1] -= k;
                    close[1] -= k;

                    if (open[1] > 0) stack.push(open);
                    if (close[1] > 0) stack.push(close);

                } else {
                    stack.push(open);
                    stack.push(close);
                    break;
                }
            }
        }

        // Build final string
        StringBuilder result = new StringBuilder();
        for (int[] pair : stack) {
            result.append(String.valueOf((char) pair[0]).repeat(pair[1]));
        }

        return result.reverse().toString();
    }
}