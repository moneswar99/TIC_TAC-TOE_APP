import java.util.Random;

public class TicTacToe {

    static char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    };

    static char computerSymbol = 'O';

    public static void main(String[] args) {
        printBoard();
        computerMove();
        printBoard();
    }

    // Function to print board
    static void printBoard() {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // UC7: Random valid move
    static void computerMove() {
        Random random = new Random();
        int row, col;

        while (true) {
            row = random.nextInt(3); // 0 to 2
            col = random.nextInt(3); // 0 to 2

            // Check if the slot is empty
            if (board[row][col] == '-') {
                board[row][col] = computerSymbol;
                System.out.println("Computer placed 'O' at (" + row + ", " + col + ")");
                break;
            }
        }
    }
}