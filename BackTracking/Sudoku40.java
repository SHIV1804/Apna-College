package BackTracking;

public class Sudoku40 {
    public static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] board, int row, int column, int digit) {
        // row
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == digit) {
                return false;
            }
        }
        // column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit) {
                return false;
            }
        }
        // grid
        int startRow = (row / 3) * 3;
        int startColumn = (column / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColumn; j < startColumn + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solvingSudoku(int[][] board, int row, int column) {
        if (row == 9) {

            return true;
        }
        int newRow = row;
        int newColumn = column + 1;
        if (newColumn== 9) {
            newRow = row + 1;
            newColumn = 0;
        }
        if (board[row][column] != 0) {
            return solvingSudoku(board, newRow, newColumn);
        }
        for (int i = 1; i < 10; i++) {
            if (isSafe(board, row, column, i)) {
                board[row][column] = i;

                if (solvingSudoku(board, newRow, newColumn)) {
                    return true;
                }
                board[row][column] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int board[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        solvingSudoku(board, 0, 0);
        print(board);
    }
}
