class Solution {
    public String resultingString(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int len = stack.length();
            if (len > 0 && isConsecutive(stack.charAt(len - 1), c)) {
                // Remove the leftmost valid adjacent pair
                stack.deleteCharAt(len - 1);
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }

    private boolean isConsecutive(char a, char b) {
        int diff = Math.abs(a - b);
        return diff == 1 || diff == 25; // circular check (a-z)
    }
}