class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int res_diag = 0;
        int res_area = 0;
        int l_max = 0;
        int w_max = 0;

        for(int i=0; i<dimensions.length; i++){
            // if(res < (int)Math.sqrt(Math.pow(dimensions[i][0], 2) + Math.pow(dimensions[i][1], 2))){
            //     res = (int) Math.sqrt(Math.pow(dimensions[i][0], 2) + Math.pow(dimensions[i][1], 2));
            //     l_max = dimensions[i][0];
            //     w_max = dimensions[i][1];
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            int diag = l*l + w*w;
            int area = l*w;

            if(diag > res_diag){
                res_diag = diag;
                res_area = area;
            }
            else if(diag == res_diag){
                res_area = Math.max(area, res_area);
            }
        }
        return res_area;
    }
}