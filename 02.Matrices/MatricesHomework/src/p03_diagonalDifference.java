import java.util.Scanner;

public class p03_diagonalDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] currentRow = in.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(currentRow[j]);
            }
        }

        int leftToRight = 0;
        int rightToLeft = 0;
        for (int i = 0; i < n; i++) {
            leftToRight += matrix[i][i];
            rightToLeft += matrix[i][n - i - 1];
        }

        System.out.println(Math.abs(leftToRight - rightToLeft));
    }
}
