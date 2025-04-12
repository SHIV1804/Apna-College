package BackTracking;

public class KnightWalk42 {
    public static void print(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int board[][], int row, int column) {
        return row > -1 && column > -1 && row < 8 && column < 8 && board[row][column] == -1;
    }

    static int visit = 0;

    public static void KnightWalk(int[][] board, int row, int column, int[] xIndex, int[] yIndex, int position) {
        if (visit == 64) {
            return;
        }

        // if (isSafe(board, row + 2, column + 1) && board[row + 2][column + 1] == -1) {
        // row = row + 2;
        // column = column + 1;
        // } else if (isSafe(board, row + 2, column - 1) && board[row + 2][column - 1]
        // == -1) {

        // row = row + 2;
        // column = column - 1;
        // } else if (isSafe(board, row + 1, column + 2) && board[row + 1][column + 2]
        // == -1) {
        // row = row + 1;
        // column = column + 2;
        // } else if (isSafe(board, row - 1, column + 2) && board[row - 1][column + 2]
        // == -1) {
        // row = row - 1;
        // column = column + 2;
        // } else if (isSafe(board, row - 2, column + 1) && board[row - 2][column + 1]
        // == -1) {
        // row = row - 2;
        // column = column + 1;
        // } else if (isSafe(board, row - 2, column - 1) && board[row - 2][column - 1]
        // == -1) {
        // row = row - 2;
        // column = column - 1;
        // } else if (isSafe(board, row + 1, column - 2) && board[row + 1][column - 2]
        // == -1) {
        // row = row + 1;
        // column = column - 2;
        // } else if (isSafe(board, row - 1, column - 2) && board[row - 1][column - 2]
        // == -1) {
        // row = row - 1;
        // column = column - 2;
        // }

        for (int i = 0; i < 8; i++) {
            int nextRow = xIndex[i] + row;
            int nextColumn = yIndex[i] + column;
            if (isSafe(board, nextRow, nextColumn)) {

                board[nextRow][nextColumn] = ++visit;
                KnightWalk(board, nextRow, nextColumn, xIndex, yIndex, i);
            }
        }

    }

    

    public static void KnightWalkCall(int[][] board, int row, int column) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = -1;
            }
        }
        board[0][0] = 0;
        int[] xIndex = { 2, 2, 1, -1, -2, -2, 1, -1 };
        int[] yIndex = { 1, -1, 2, 2, 1, 1, -2, -2 };
        KnightWalk(board, row, column, xIndex, yIndex, 0);
    }

    public static void main(String[] args) {
        int[][] board = new int[8][8];

        KnightWalkCall(board, 0, 0);
        print(board);
    }
}
