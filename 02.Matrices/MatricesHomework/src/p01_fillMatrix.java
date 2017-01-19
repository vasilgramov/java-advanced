import java.util.Scanner;

public class p01_fillMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] line = in.nextLine().split(",\\s+");
        int n = Integer.parseInt(line[0]);
        String pattern = line[1];

        int[][] matrix = new int[n][n];
        int counter = 1;
        if (pattern.equals("A")) {
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < n; j++) {
                        matrix[j][i] = counter;
                        counter++;
                    }
                } else {
                    for (int j = n - 1; j >= 0; j--) {
                        matrix[j][i] = counter;
                        counter++;
                    }
                }
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}
