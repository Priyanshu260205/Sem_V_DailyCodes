class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for(int i: cards){
            nums.add((double) i);
        }
        return helper(nums);
    }

    private boolean helper(List<Double> nums){
        int n = nums.size();

        if(n == 1){
            return Math.abs(nums.get(0) - 24.0) < 0.00001;
        }
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                double x = nums.get(i);
                double y = nums.get(j);

                List<Double> ops = calc_ops(x,y);
                List<Double> next_r = new ArrayList<>();
                for(int k=0; k<n; k++){
                    if(k != i && k != j){
                        next_r.add(nums.get(k));
                    }
                }

                for(Double op: ops){
                    next_r.add(op);
                    if(helper(next_r)){
                        return true;
                    }
                    next_r.remove(next_r.size()-1);
                }
            }
        }
        return false;
    }

    private List<Double> calc_ops(double a, double b){
        List<Double> res = new ArrayList<>();

        res.add(a+b);
        res.add(a-b);
        res.add(b-a);
        res.add(a*b);
        res.add(a/b);
        res.add(b/a);

        return res;
    }
}