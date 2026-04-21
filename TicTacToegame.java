import java.util.Random;

public class tictactoegame {

    static char[][] board = new char[3][3];

    static char humanSymbol;
    static char computerSymbol;
    static char currentPlayer;

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

    public static void main(String[] args) {
        initializeBoard();   // UC1
        printBoard();        // Display board
        tossAndAssign();     // UC2
    }
}