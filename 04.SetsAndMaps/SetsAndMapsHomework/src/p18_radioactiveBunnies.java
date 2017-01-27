import java.util.Scanner;

public class p18_radioactiveBunnies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int playerRow = 0;
        int playerCol = 0;

        int rows = in.nextInt();
        int cols = in.nextInt();
        char[][] matrix = new char[rows][cols];

        in.nextLine();

        for (int i = 0; i < rows; i++) {
            char[] currentRow = in.nextLine().toCharArray();
            for (int j = 0; j < currentRow.length; j++) {
                if (currentRow[j] == 'P') {
                    playerRow = i;
                    playerCol = j;
                }
                matrix[i][j] = currentRow[j];
            }
        }

        char[] playerMoves = in.nextLine().toCharArray();
        for (int i = 0; i < playerMoves.length; i++) {
            char currentDirection = playerMoves[i];

            int copyPlayerRow = playerRow;
            int copyPlayerCol = playerCol;

            matrix[playerRow][playerCol] = '.';

            switch (currentDirection) { // move player
                case 'U':
                    playerRow--;
                    break;
                case 'R':
                    playerCol++;
                    break;
                case 'D':
                    playerRow++;
                    break;
                case 'L':
                    playerCol--;
                    break;
            }


            /* summary
            spreading bunnies..
            first we set neighbor cells to 'A' only if they are empty '.'
            so if the cell is == 'A' we won't spread again
            then we set A's to B's
             */
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    if (matrix[j][k] == 'B') {
                        if (isInsideMatrix(j - 1, k, rows, cols) && matrix[j - 1][k] == '.') {
                            matrix[j - 1][k] = 'A';
                        }

                        if (isInsideMatrix(j, k + 1, rows, cols) && matrix[j][k + 1] == '.') {
                            matrix[j][k + 1] = 'A';
                        }

                        if (isInsideMatrix(j + 1, k, rows, cols) && matrix[j + 1][k] == '.') {
                            matrix[j + 1][k] = 'A';
                        }

                        if (isInsideMatrix(j, k - 1, rows, cols) && matrix[j][k - 1] == '.') {
                            matrix[j][k - 1] = 'A';
                        }
                    }
                }
            }

            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    if (matrix[j][k] == 'A')
                        matrix[j][k] = 'B';
                }
            }

            if (!isInsideMatrix(playerRow, playerCol, rows, cols)) { // win
                printMatrix(matrix);

                System.out.println("won: " + copyPlayerRow + " " + copyPlayerCol);
                return;
            }

            if (matrix[playerRow][playerCol] == 'B') {              // loose
                printMatrix(matrix);

                System.out.println("dead: " + playerRow + " " + playerCol);
                return;
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }

            System.out.println();
        }
    }

    private static boolean isInsideMatrix(int row, int col, int rows, int cols) {
        if (row >= 0 && row < rows && col >= 0 && col < cols)
            return true;

        return false;
    }
}