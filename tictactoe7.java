public class tictactoe7 {

    // Board declaration
    static char[][] board = {
        {'X', 'O', 'X'},
        {'X', 'O', 'O'},
        {'O', 'X', 'X'}
    };

    // UC10: Detect Draw Condition
    public static boolean isDraw() {

        // Traverse board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                // If empty cell exists → not draw
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        // No empty cells → draw
        return true;
    }

    // Main method
    public static void main(String[] args) {

        if (isDraw()) {
            System.out.println("It's a Draw!");
        } else {
            System.out.println("Game not finished yet.");
        }
    }
}