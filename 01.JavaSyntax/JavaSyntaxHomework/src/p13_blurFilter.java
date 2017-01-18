import java.util.Scanner;

public class p13_blurFilter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int blurAmount = Integer.parseInt(in.nextLine());

        String[] matrixArgs = in.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixArgs[0]);
        int cols = Integer.parseInt(matrixArgs[1]);
        long[][] matrix = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] currentRow = in.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(currentRow[j]);
            }
        }

        String[] blurCoordinates = in.nextLine().split("\\s+");
        int blurRow = Integer.parseInt(blurCoordinates[0]);
        int blurCol = Integer.parseInt(blurCoordinates[1]);

        if (isInMatrix(blurRow - 1, blurCol - 1, rows, cols)) {
            matrix[blurRow - 1][blurCol - 1] += blurAmount;
        }

        if (isInMatrix(blurRow - 1, blurCol, rows, cols)) {
            matrix[blurRow - 1][blurCol] += blurAmount;
        }

        if (isInMatrix(blurRow - 1, blurCol + 1, rows, cols)) {
            matrix[blurRow - 1][blurCol + 1] += blurAmount;
        }

        if (isInMatrix(blurRow, blurCol - 1, rows, cols)) {
            matrix[blurRow][blurCol - 1] += blurAmount;
        }

        if (isInMatrix(blurRow, blurCol, rows, cols)) {
            matrix[blurRow][blurCol] += blurAmount;
        }

        if (isInMatrix(blurRow, blurCol + 1, rows, cols)) {
            matrix[blurRow][blurCol + 1] += blurAmount;
        }

        if (isInMatrix(blurRow + 1, blurCol - 1, rows, cols)) {
            matrix[blurRow + 1][blurCol - 1] += blurAmount;
        }

        if (isInMatrix(blurRow + 1, blurCol, rows, cols)) {
            matrix[blurRow + 1][blurCol] += blurAmount;
        }

        if (isInMatrix(blurRow + 1, blurCol + 1, rows, cols)) {
            matrix[blurRow + 1][blurCol + 1] += blurAmount;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    static private boolean isInMatrix(int row, int col, int totalRows, int totalCols) {
        boolean isInRow = row >= 0 && row < totalRows;
        boolean isInCol = col >= 0 && col < totalCols;

        return isInRow && isInCol;
    }
}
