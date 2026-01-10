class Solution {
    public long maxStrength(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();
        boolean hasZero = false;

        for (int x : nums) {
            if (x > 0) positives.add(x);
            else if (x < 0) negatives.add(x);
            else hasZero = true;
        }

        long strength = 1;
        boolean selected = false;
        for (int p : positives) {
            strength *= p;
            selected = true;
        }

        Collections.sort(negatives);
        if (negatives.size() % 2 != 0) {
            negatives.remove(negatives.size() - 1);
        }

        for (int neg : negatives) {
            strength *= neg;
            selected = true;
        }
        if (!selected) {
            return 0;
        }

        return strength;
    }
}