class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> res = new ArrayList<>();
        int lowlen = String.valueOf(low).length();
        int highlen = String.valueOf(high).length();
        for(int left=lowlen; left <= highlen; left++){
            for(int right=0; right<=digits.length()-left; right++){
                String seqString = digits.substring(right, right+left);
                int num = Integer.parseInt(seqString);
                if(num >= low && num <= high){
                    res.add(num);
                }
            }
        }
        return res;
    }
}