class Solution {
    public boolean isValidSudoku(char[][] board) {
                Set<String> set = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];

                if (ch == '.') {
                    continue;
                }

                String row = "ROW_" + r + "_" + ch;
                String column = "COLUMN_" + c + "_" + ch;
                String grid = "GRID_" + r/3 + "_" + c/3 + "_" + ch;

                if (set.contains(row) || set.contains(column) || set.contains(grid)) {
                    return false;
                }
                set.add(row);
                set.add(column);
                set.add(grid);
            }
        }
        return true;
    }
}