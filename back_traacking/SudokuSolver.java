package back_traacking;

public class SudokuSolver {

    public static void main(String[] args) {
        int[][] grid = { 
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };

        if (solveSudoku(grid, 0, 0)) {
            printGrid(grid);
        } else {
            System.out.println("No solution exists.");
        }
    }

    public static boolean solveSudoku(int[][] grid, int row, int col) {
        if (row == 9) { // Base case: End of board
            return true;
        }
        if (col == 9) { // Move to next row
            return solveSudoku(grid, row + 1, 0);
        }
        if (grid[row][col] != 0) { // Skip pre-filled cells
            return solveSudoku(grid, row, col + 1);
        }

        for (int val = 1; val <= 9; val++) {
            if (isItSafe(grid, row, col, val)) {
                grid[row][col] = val;
                if (solveSudoku(grid, row, col + 1)) {
                    return true;
                }
                grid[row][col] = 0; // Backtrack
            }
        }
        return false; // No valid number found
    }

    public static boolean isItSafe(int[][] grid, int row, int col, int val) {
        // Check row
        for (int c = 0; c < 9; c++) {
            if (grid[row][c] == val) return false;
        }

        // Check column
        for (int r = 0; r < 9; r++) {
            if (grid[r][col] == val) return false;
        }

        // Check 3x3 sub-grid
        int rStart = row - row % 3;
        int cStart = col - col % 3;
        for (int i = rStart; i < rStart + 3; i++) {
            for (int j = cStart; j < cStart + 3; j++) {
                if (grid[i][j] == val) return false;
            }
        }

        return true;
    }

    public static void printGrid(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
