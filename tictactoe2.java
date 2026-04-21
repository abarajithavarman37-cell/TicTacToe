import java.util.Random;
import java.util.Scanner;

public class tictactoe2 {

    static char[][] board = new char[3][3];

    static char humanSymbol;
    static char computerSymbol;
    static char currentPlayer;

    static Scanner scanner = new Scanner(System.in);

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
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Toss and assign symbols
    public static void tossAndAssign() {
        Random rand = new Random();
        int toss = rand.nextInt(2);

        if (toss == 0) {
            System.out.println("Human wins the toss!");
            humanSymbol = 'X';
            computerSymbol = 'O';
            currentPlayer = humanSymbol;
        } else {
            System.out.println("Computer wins the toss!");
            computerSymbol = 'X';
            humanSymbol = 'O';
            currentPlayer = computerSymbol;
        }

        System.out.println("Human Symbol: " + humanSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
        System.out.println("First turn: " + currentPlayer);
    }

    // Get user input
    public static int getUserInput() {
        System.out.print("Enter your move (1-9): ");
        return scanner.nextInt();
    }

    // Convert slot to row & column
    public static int[] convertSlotToPosition(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // Validate move
    public static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        if (board[row][col] != '-') {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        tossAndAssign();

        int slot = getUserInput();
        int[] pos = convertSlotToPosition(slot);

        int row = pos[0];
        int col = pos[1];

        if (isValidMove(row, col)) {
            System.out.println("Valid Move ✅");
        } else {
            System.out.println("Invalid Move ❌");
        }
    }
}