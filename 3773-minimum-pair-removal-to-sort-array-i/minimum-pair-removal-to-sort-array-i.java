class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int operations = 0;
        while (!is_non_decreasing(list)) {
            int min_sum = Integer.MAX_VALUE, min_index = -1;

            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < min_sum) {
                    min_sum = sum;
                    min_index = i;
                }
            }

            list.set(min_index, min_sum);
            list.remove(min_index + 1);
            operations++;
        }

        return operations;
    }

    public boolean is_non_decreasing(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}