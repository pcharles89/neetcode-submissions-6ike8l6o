class Solution {
    public boolean isValidSudoku(char[][] board) {
        // rows[r][d] = have we seen digit d in row r?
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;

                int d = ch - '0';                 // digit 1..9
                int box = (r / 3) * 3 + (c / 3);  // box index 0..8

                if (rows[r][d] || cols[c][d] || boxes[box][d]) {
                    return false;
                }

                rows[r][d] = true;
                cols[c][d] = true;
                boxes[box][d] = true;
            }
        }
        return true;
    }
}

