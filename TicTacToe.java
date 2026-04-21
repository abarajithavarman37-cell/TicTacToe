public class TicTacToe {

    // 3x3 board
    static char[][] board = new char[3][3];

    // Initialize board with '-'
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Print the board
    public static void printBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); // move to next line
        }
    }

    // Main method
    public static void main(String[] args) {
        initializeBoard();   // Step 1: Initialize board
        printBoard();        // Step 2: Display board
    }
}