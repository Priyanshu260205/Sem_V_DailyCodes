class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int ans = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int steps = 0;

            while (!stack.isEmpty() && nums[i] > stack.peek()[0]) {
                steps = Math.max(steps + 1, stack.peek()[1]);
                stack.pop();
            }

            ans = Math.max(ans, steps);
            stack.push(new int[]{nums[i], steps});
        }

        return ans;
    }
}