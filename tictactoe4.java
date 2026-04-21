import java.util.Random;
import java.util.Scanner;

public class tictactoe4 {

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
        if (row < 0 || row > 2 || col < 0 || col > 2) return false;
        if (board[row][col] != '-') return false;
        return true;
    }

    // Place move
    public static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7: Computer random move
    public static void computerMove() {
        int slot;
        int row, col;

        while (true) {
            slot = rand.nextInt(9) + 1; // 1–9
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

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        tossAndAssign();

        // Human move
        int slot = getUserInput();
        int[] pos = convertSlotToPosition(slot);

        if (isValidMove(pos[0], pos[1])) {
            placeMove(pos[0], pos[1], humanSymbol);
        }

        printBoard();

        // Computer move
        computerMove();
        printBoard();
    }
}