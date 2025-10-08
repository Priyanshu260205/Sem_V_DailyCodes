import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];

            // minimum potion strength required to reach success
            long minPotion = (success + spell - 1) / spell;  // ceiling division

            // find the first potion >= minPotion using binary search
            int idx = binarySearch(potions, minPotion);

            // count of successful potions
            ans[i] = m - idx;
        }

        return ans;
    }

    private int binarySearch(int[] potions, long target) {
        int left = 0, right = potions.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left; // left is the first index where potion >= target
    }
}
