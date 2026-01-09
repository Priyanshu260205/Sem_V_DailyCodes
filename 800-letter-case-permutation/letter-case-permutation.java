class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        helper(s.toCharArray(), 0, new StringBuilder(), res);

        return res;
    }

    public void helper(char[] arr, int idx, StringBuilder sb, List<String> res){
        if(idx == arr.length){
            res.add(sb.toString());
            return;
        }

        char a = arr[idx];
        if(Character.isLetter(a)){
            sb.append(Character.toLowerCase(a));
            helper(arr, idx+1, sb, res);
            sb.deleteCharAt(sb.length()-1);

            sb.append(Character.toUpperCase(a));
            helper(arr, idx+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            sb.append(a);
            helper(arr,idx+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}