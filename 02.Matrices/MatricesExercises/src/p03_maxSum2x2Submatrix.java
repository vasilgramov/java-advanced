import java.util.Scanner;

public class p03_maxSum2x2Submatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] matrixArgs = in.nextLine().split(",\\s+");
        int rows = Integer.parseInt(matrixArgs[0]);
        int cols = Integer.parseInt(matrixArgs[1]);

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] currentRow = in.nextLine().split(",\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(currentRow[j]);
            }
        }

        int startRow = 0;
        int startCol = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];

                if (currentSum > maxSum) {
                    maxSum = currentSum;

                    startRow = i;
                    startCol = j;
                }
            }
        }

        System.out.println(matrix[startRow][startCol] + " " + matrix[startRow][startCol + 1]);
        System.out.println(matrix[startRow + 1][startCol] + " " + matrix[startRow + 1][startCol + 1]);
        System.out.println(maxSum);
    }
}
