import java.util.Scanner;

public class p07_collectCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[][] matrix = new char[4][];
        for (int i = 0; i < 4; i++) {
            char[] currentRow = in.nextLine().toCharArray();
            matrix[i] = new char[currentRow.length];
            for (int j = 0; j < currentRow.length; j++) {
                matrix[i][j] = currentRow[j];
            }
        }

        char[] moves = in.nextLine().toCharArray();
        int currentRow = 0;
        int currentCol = 0;

        int coins = 0;
        int wallsHit = 0;
        if (matrix[currentRow][currentCol] == '$')
            coins++;

        for (int i = 0; i < moves.length; i++) {
            int copyRow = currentRow;
            int copyCol = currentCol;

            switch (moves[i]) {
                case '^':
                    currentRow--;
                    break;
                case '>':
                    currentCol++;
                    break;
                case 'V':
                    currentRow++;
                    break;
                case '<':
                    currentCol--;
                    break;
            }

            if (!isInMatrix(currentRow, currentCol, matrix)) {
                currentRow = copyRow;
                currentCol = copyCol;
                wallsHit++;
            } else {
                if (matrix[currentRow][currentCol] == '$')
                    coins++;
            }
        }

        System.out.println("Coins = " + coins);
        System.out.println("Walls = " + wallsHit);
    }

    private static boolean isInMatrix(int currentRow, int currentCol, char[][] matrix) {
        if (currentRow >= 0 && currentCol >= 0 && currentRow < 4 && currentCol < matrix[currentRow].length) {
            return true;
        }

        return false;
    }
}
