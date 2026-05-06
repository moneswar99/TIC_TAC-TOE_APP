import java.util.Scanner;
import java.util.Random;

public class uc8 {

    static boolean isHumanTurn = true;
    static boolean gameOver = false;
    static char[] board = {'1','2','3','4','5','6','7','8','9'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printBoard();

            if (isHumanTurn) {
                System.out.print("Enter position (1-9): ");
                int pos = sc.nextInt();

                if (isValidMove(pos)) {
                    board[pos - 1] = 'X';
                    isHumanTurn = false;
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            } else {
                computerMove();
                isHumanTurn = true;
            }

            checkWinner();
        }

        printBoard();
        sc.close();
    }

    static void printBoard() {
        System.out.println();
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("--+---+--");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("--+---+--");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    static boolean isValidMove(int pos) {
        if (pos < 1 || pos > 9) return false;
        return board[pos - 1] != 'X' && board[pos - 1] != 'O';
    }

    static void computerMove() {
        Random rand = new Random();
        int pos;

        do {
            pos = rand.nextInt(9) + 1;
        } while (!isValidMove(pos));

        System.out.println("Computer chooses: " + pos);
        board[pos - 1] = 'O';
    }

    static void checkWinner() {
        int[][] winPositions = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
        };

        for (int[] wp : winPositions) {
            if (board[wp[0]] == board[wp[1]] &&
                board[wp[1]] == board[wp[2]]) {

                printBoard();
                System.out.println("Winner: " + board[wp[0]]);
                gameOver = true;
                return;
            }
        }

        // Check draw
        boolean draw = true;
        for (char c : board) {
            if (c != 'X' && c != 'O') {
                draw = false;
                break;
            }
        }

        if (draw) {
            printBoard();
            System.out.println("It's a Draw!");
            gameOver = true;
        }
    }
}