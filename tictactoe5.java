import java.util.Random;
import java.util.Scanner;

public class tictactoe5{

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

    // Toss
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

    // Input
    public static int getUserInput() {
        System.out.print("Enter your move (1-9): ");
        return scanner.nextInt();
    }

    // Convert slot
    public static int[] convertSlotToPosition(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // Validate
    public static boolean isValidMove(int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
    }

    // Place move
    public static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Computer move
    public static void computerMove() {
        int row, col;

        while (true) {
            int slot = rand.nextInt(9) + 1;
            int[] pos = convertSlotToPosition(slot);

            row = pos[0];
            col = pos[1];

            if (isValidMove(row, col)) {
                placeMove(row, col, computerSymbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // Check win
    public static boolean checkWin(char symbol) {
        // rows & columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }

        // diagonals
        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
            (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
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

    // Switch turn
    public static void switchPlayer() {
        if (currentPlayer == humanSymbol)
            currentPlayer = computerSymbol;
        else
            currentPlayer = humanSymbol;
    }

    public static void main(String[] args) {

        initializeBoard();
        tossAndAssign();
        printBoard();

        // UC8: Game Loop
        while (true) {

            if (currentPlayer == humanSymbol) {
                int slot = getUserInput();
                int[] pos = convertSlotToPosition(slot);

                if (isValidMove(pos[0], pos[1])) {
                    placeMove(pos[0], pos[1], humanSymbol);
                } else {
                    System.out.println("Invalid move! Try again.");
                    continue; // retry same turn
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

            // Switch turn
            switchPlayer();
        }
    }
}