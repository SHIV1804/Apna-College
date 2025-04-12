package BackTracking;
public class NQueens38 {
    static int count = 1;
    public static void print(char[][] board) {
        System.out.println("Chessboard : "+count++);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }
    // public static void nQueens(char[][] board,int row , int column){
    // if (row==board.length) {
    // print(board);
    // return;
    // }
    // if (column==board.length) {

    // return;
    // }
    // board[row][column] = 'Q';
    // nQueens(board, row+1, column);
    // board[row][column] = 'x';
    // nQueens(board, row, column+1);
    // }
    public static boolean isSafe(char[][] board, int row, int column) {
        //vertical up
        for (int i = row-1; i > -1; i--) {
            if (board[i][column] == 'Q') {
                return false;
            }
        }
        //diagonal left
        for (int i = row-1, j = column-1; i > -1 && j > -1; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
           
            }
        }
        //diagonal right
        for (int i = row-1, j = column+1; i > -1 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    //all possible solutions
    public static void nQueens(char[][] board, int row) {
        if (row == board.length) {
            print(board);
            return;
        }
        for (int column = 0; column < board.length; column++) {
            if (isSafe(board, row, column)) {
                board[row][column] = 'Q';
                nQueens(board, row + 1);
                board[row][column] = 'x';
            }
        }

    }
    //only one solution
    public static boolean nQueensOne(char[][] board, int row) {
        if (row == board.length) {
            print(board);
            return true;
        }
        for (int column = 0; column < board.length; column++) {
            if (isSafe(board, row, column)) {
                board[row][column] = 'Q';
                if(nQueensOne(board, row + 1)) return true;
                board[row][column] = 'x';
            }
        }
        return false;

    }
    public static void main(String[] args) {
        int length=4;
        char[][] board = new char[length][length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'x';

            }
        }
        nQueensOne(board, 0);
    }
}
