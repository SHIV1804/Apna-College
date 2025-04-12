package BackTracking;

public class RatProblem41 {
    public static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] board, int row, int column) {
        return row >= 0 && row < board.length && column < board.length && column >= 0 && board[row][column] == 1;
    }

    // public static boolean ratInAMaze(int[][] maze, int row, int column,int [][]solution) {
    //     if (row == maze.length - 1 && column == maze.length - 1&&maze[row][column]==1) {
    //         solution[row][column] =1;
    //         print(solution);
    //         return true;
    //     } 
        
    //     if (isSafe(maze, row, column)) {
            
    //         if (solution[row][column]==1) {
    //             return false;
    //         }
    //         solution[row][column] = 1;
    //         if(ratInAMaze(maze, row, column + 1,solution)){
    //             return true;
    //         }
    //         if(ratInAMaze(maze, row + 1, column,solution)){
    //             return true;
    //         }
    //         solution[row][column] = 0;
    //     }
    //     return false;
    // }
    static int count=1;
    public static void ratInAMaze(int[][] maze, int row, int column,int [][]solution) {
        if (row == maze.length - 1 && column == maze.length - 1&&maze[row][column]==1) {
            solution[row][column] =1;
            System.out.println("Solution : "+count++);
            print(solution);
            return;
        } 
        
        if (isSafe(maze, row, column)) {
            
            if (solution[row][column]==1) {
                return ;
            }
            solution[row][column] = 1;
            ratInAMaze(maze, row, column + 1,solution);
               
            ratInAMaze(maze, row + 1, column,solution);
            solution[row][column] = 0;
        }
        
    }
    public static void rat(int [][] maze,int row,int column){
        int [][] solution = new int[maze.length][maze.length];
        ratInAMaze(maze, row, column, solution);
    }
    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 1, 1 },
                         { 0, 1, 0, 1 },
                         { 1, 1, 1, 1 }
        };
    
        rat(maze, 0, 0);

    }
}
