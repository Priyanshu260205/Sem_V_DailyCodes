class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        int idx = 0;
        for(int[] x : queries){
            int e = x[0];
            int f = x[1];
            res[idx++] = solver(e, f);
        }

        return res;
    }

    public static int solver(int x, int y){
        int res = 1;
        while(x != y){
            if(x > y) x/=2;
            else y /= 2;

            res++;
        }

        return res;
    }
}