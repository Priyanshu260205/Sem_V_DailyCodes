class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> o_li = new ArrayList<>();
        int input = 1;
        for(int num: target){
            while(input < num){
                o_li.add("Push");
                o_li.add("Pop");
                input++;
            }
            o_li.add("Push");
            input++;
        }
        return o_li;
    }
}