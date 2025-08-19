class Solution {
    public int numberOfBeams(String[] bank) {
        int total_beans = 0;
        int prev_row_dev = 0;
        for(String row : bank){
            int curr_row_dev = 0;
            for(int i=0; i<row.length(); i++){
                if(row.charAt(i) == '1'){
                    curr_row_dev++;
                }
            }
            if(curr_row_dev > 0){
                total_beans += (prev_row_dev * curr_row_dev);
                prev_row_dev = curr_row_dev;
            }
        }

        return total_beans;
    }
}