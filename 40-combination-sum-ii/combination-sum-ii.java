class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] arr, int target, int start,
                           List<Integer> path, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            // Skip duplicates at the same level
            if (i > start && arr[i] == arr[i - 1]) continue;

            if (arr[i] > target) break; // pruning

            path.add(arr[i]);
            backtrack(arr, target - arr[i], i + 1, path, res);
            path.remove(path.size() - 1); // backtrack
        }
    }
}