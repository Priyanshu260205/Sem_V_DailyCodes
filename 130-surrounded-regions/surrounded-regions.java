class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        int r = board.length;
        int c = board[0].length;

        for(int i=0; i<r; i++){
            dfs(board, i, 0); 
            dfs(board, i, c-1); 
        }
        for(int i=0; i<c; i++){
            dfs(board, 0, i); 
            dfs(board, r-1, i); 
        }


        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int r, int c){
        if(r < 0 || c < 0 || r == board.length || c == board[0].length){
            return;
        }

        if(board[r][c] != 'O') return;
        board[r][c] = '#';

        dfs(board, r+1, c);
        dfs(board, r-1, c);
        dfs(board, r, c+1);
        dfs(board, r, c-1);
    }
}