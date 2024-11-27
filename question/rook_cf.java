package question;

import java.util.Scanner;

public class rook_cf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();  // Number of test cases
        scanner.nextLine();  // Consume the newline character

        for (int i = 0; i < t; i++) {
            String position = scanner.nextLine().trim();
            rookMoves(position);
        }

        scanner.close();
    }

    public static void rookMoves(String position) {
        char column = position.charAt(0);  // Column ('a' to 'h')
        char row = position.charAt(1);     // Row ('1' to '8')

        // Columns are from 'a' to 'h'
        String columns = "abcdefgh";
        // Rows are from '1' to '8'
        String rows = "12345678";

        // StringBuilder to store all possible moves
        StringBuilder possibleMoves = new StringBuilder();

        // Add all moves in the same row (vary column)
        for (char c : columns.toCharArray()) {
            if (c != column) {
                possibleMoves.append(c).append(row).append(" ");
            }
        }

        // Add all moves in the same column (vary row)
        for (char r : rows.toCharArray()) {
            if (r != row) {
                possibleMoves.append(column).append(r).append(" ");
            }
        }


        System.out.println(possibleMoves.toString().trim());
    }
}
