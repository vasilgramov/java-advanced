import java.util.Scanner;

public class p04_squaresInMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rows = in.nextInt();
        int cols = in.nextInt();
        in.nextLine();
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] currentRow = in.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = currentRow[j];
            }
        }

        int count = 0;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (matrix[i][j].equals(matrix[i + 1][j]) &&
                        matrix[i][j].equals(matrix[i][j + 1]) &&
                        matrix[i][j].equals(matrix[i + 1][j + 1]))
                    count++;
            }
        }

        System.out.println(count);
    }
}
