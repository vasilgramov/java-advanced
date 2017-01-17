import java.util.IntSummaryStatistics;
import java.util.Scanner;

public class p02_sumMatrixElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] matrixArgs = in.nextLine().split(",\\s+");
        int rows = Integer.parseInt(matrixArgs[0]);
        int cols = Integer.parseInt(matrixArgs[1]);

        int sum = 0;
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] currentRow = in.nextLine().split(",\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(currentRow[j]);
                sum += Integer.parseInt(currentRow[j]);
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
