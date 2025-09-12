class Solution {
    public boolean doesAliceWin(String s) {
        String vowels = "aeiou";
        int v_Count = 0;

        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                v_Count += 1;
            }
        }

        return v_Count > 0;
    }
}