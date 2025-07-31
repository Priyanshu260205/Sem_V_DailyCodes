class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        
        Set<Integer> pre = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for(int i: arr){
            for(int a: pre){
                res.add(i | a);
                curr.add(i | a);
            }

            res.add(i);
            curr.add(i);

            pre = curr;
            curr = new HashSet<>();
        }

    return res.size();
    }
}