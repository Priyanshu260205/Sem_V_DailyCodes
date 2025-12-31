class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    public boolean backtrack(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    for(char num='1'; num<='9'; num++){
                        if(isValid(board, i, j, num)){
                            board[i][j] = num;
                            if(backtrack(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char n){
        for(int i=0; i<9; i++){
            if(board[i][col] == n) return false;
            if(board[row][i] == n) return false;

            int nr = 3 * (row/3) + i/3;
            int nc = 3 * (col/3) + i%3;
            if(board[nr][nc] == n) return false;

        }
        return true;
    }
}