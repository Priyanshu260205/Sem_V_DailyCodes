class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] i : board){
            Arrays.fill(i, '.');
        }
        backtrack(board, 0);
        return res;
    }

    public void backtrack(char[][] board, int row){
        if(row == board.length){
            res.add(construct(board));
            return;
        }

        for(int i=0; i<board.length; i++){
            if(isSafe(board, row, i)){
                board[row][i] = 'Q';
                backtrack(board, row+1);
                board[row][i] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col){
        for(int i=0; i<row; i++){
            if(board[i][col] == 'Q') return false;
        }

        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q') return false;
        }
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }

    public List<String> construct(char[][] board){
        ArrayList<String> list = new ArrayList<>();
        for(char[] i : board){
            list.add(new String(i));
        }

        return list;
    }
}