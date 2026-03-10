class Solution {
    public String reverseWords(String s) {
        s = s.trim();
		String str[] = s.split("\\s+");

		StringBuilder res = new StringBuilder("");
		for(int i = str.length-1; i>=0; i--)
		{
			if(i == 0) res.append(str[i]);
            else res.append(str[i] + " ");
		}
		
		return res.toString();
    }
}