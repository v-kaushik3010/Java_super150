package back_traacking;

public class N_queen {

    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];
        print(board, 0);
    }

    public static void print(boolean[][] board, int row) {
        if (row == board.length) { // If all queens are placed
            Display(board);
            System.out.println();
            return;
        }
        for (int col = 0; col < board[0].length; col++) {
            if (isItSafe(board, row, col)) {
                board[row][col] = true;
                print(board, row + 1); // Move to the next row
                board[row][col] = false; // Backtrack
            }
        }
    }

    public static void Display(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]) {
                    System.out.print("Q" + " ");
                } else {
                    System.out.print("."+ " ");
                }
            }
            System.out.println();
        }
    }

    public static boolean isItSafe(boolean[][] board, int row, int col) {
        // Check vertical column
        for (int r = row; r >= 0; r--) {
            if (board[r][col]) return false;
        }

        // Check left diagonal
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c]) return false;
        }

        // Check right diagonal
        for (int r = row, c = col; r >= 0 && c < board[0].length; r--, c++) {
            if (board[r][c]) return false;
        }

        return true;
    }
}
