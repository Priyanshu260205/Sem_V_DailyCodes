class Solution {
    public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder();
        if(n.charAt(0)=='-'){
            sb.append('-');
            int i=1;
            while(i<n.length()&&(n.charAt(i)-'0')<=x){
                i++;
            }
            sb.append(n.substring(1,i));
            sb.append(Integer.toString(x));
            sb.append(n.substring(i));
        }else{
            int i=0;
            while(i<n.length()&&(n.charAt(i)-'0')>=x){
                i++;
            }
            sb.append(n.substring(0,i));
            sb.append(Integer.toString(x));
            sb.append(n.substring(i));
        }
        return sb.toString();
    }
}