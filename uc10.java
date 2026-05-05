import java.util.Scanner;

public class uc10 {

    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        initializeBoard();
        printBoard();

        while (true) {
            System.out.println("Player " + currentPlayer + " turn");

            System.out.print("Enter row (0-2): ");
            int row = sc.nextInt();

            System.out.print("Enter col (0-2): ");
            int col = sc.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();

                if (checkWin()) {
                    System.out.println("🎉 Player " + currentPlayer + " wins!");
                    break;
                }

                if (isDraw()) {
                    System.out.println("🤝 It's a draw!");
                    break;
                }

                switchPlayer();
            } else {
                System.out.println("❌ Invalid move, try again.");
            }
        }

        sc.close();
    }

    // Initialize board with '-'
    static void initializeBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = '-';
            }
        }
    }

    // Print board
    static void printBoard() {
        System.out.println("\nBoard:");
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check valid move
    static boolean isValidMove(int r, int c) {
        return r >= 0 && r < 3 && c >= 0 && c < 3 && board[r][c] == '-';
    }

    // Switch player
    static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Check win
    static boolean checkWin() {
        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer)
                return true;

            if (board[0][i] == currentPlayer &&
                board[1][i] == currentPlayer &&
                board[2][i] == currentPlayer)
                return true;
        }

        // Diagonals
        if (board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer)
            return true;

        if (board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer)
            return true;

        return false;
    }

    // Check draw
    static boolean isDraw() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == '-')
                    return false;
            }
        }
        return true;
    }
}