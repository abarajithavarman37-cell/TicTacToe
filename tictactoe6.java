import java.util.Random;
import java.util.Scanner;

public class tictactoe6 {

    static char[][] board = new char[3][3];

    static char humanSymbol;
    static char computerSymbol;
    static char currentPlayer;

    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();

    // Initialize board
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Print board
    public static void printBoard() {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Toss and assign symbols
    public static void tossAndAssign() {
        int toss = rand.nextInt(2);

        if (toss == 0) {
            humanSymbol = 'X';
            computerSymbol = 'O';
            currentPlayer = humanSymbol;
            System.out.println("Human starts!");
        } else {
            computerSymbol = 'X';
            humanSymbol = 'O';
            currentPlayer = computerSymbol;
            System.out.println("Computer starts!");
        }
    }

    // Get user input
    public static int getUserInput() {
        System.out.print("Enter your move (1-9): ");
        return scanner.nextInt();
    }

    // Convert slot to position
    public static int[] convertSlotToPosition(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // Validate move
    public static boolean isValidMove(int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
    }

    // Place move
    public static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Computer move
    public static void computerMove() {
        while (true) {
            int slot = rand.nextInt(9) + 1;
            int[] pos = convertSlotToPosition(slot);

            if (isValidMove(pos[0], pos[1])) {
                placeMove(pos[0], pos[1], computerSymbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // UC9: Check winning condition
    public static boolean checkWin(char symbol) {

        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {
                return true;
            }
        }

        // Columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol &&
                board[1][j] == symbol &&
                board[2][j] == symbol) {
                return true;
            }
        }

        // Diagonals
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {
            return true;
        }

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {
            return true;
        }

        return false;
    }

    // Check draw
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }

    // Switch player
    public static void switchPlayer() {
        if (currentPlayer == humanSymbol)
            currentPlayer = computerSymbol;
        else
            currentPlayer = humanSymbol;
    }

    // MAIN GAME
    public static void main(String[] args) {

        initializeBoard();
        tossAndAssign();
        printBoard();

        while (true) {

            if (currentPlayer == humanSymbol) {

                int slot = getUserInput();
                int[] pos = convertSlotToPosition(slot);

                if (isValidMove(pos[0], pos[1])) {
                    placeMove(pos[0], pos[1], humanSymbol);
                } else {
                    System.out.println("Invalid move! Try again.");
                    continue;
                }

            } else {
                computerMove();
            }

            printBoard();

            // Check win
            if (checkWin(currentPlayer)) {
                if (currentPlayer == humanSymbol)
                    System.out.println("🎉 Human Wins!");
                else
                    System.out.println("🤖 Computer Wins!");
                break;
            }

            // Check draw
            if (isBoardFull()) {
                System.out.println("It's a Draw!");
                break;
            }

            switchPlayer();
        }
    }
}