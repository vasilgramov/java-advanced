import java.util.Scanner;

public class p05_maxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rows = in.nextInt();
        int cols = in.nextInt();
        in.nextLine();

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] currentLine = in.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(currentLine[j]);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                int currentSum = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        currentSum += matrix[k][l];
                    }
                }

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    startRow = i;
                    startCol = j;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}
