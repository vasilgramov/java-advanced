import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] matrixArgs = in.readLine().split("\\s+");
        int rows = Integer.parseInt(matrixArgs[0]);
        int cols = Integer.parseInt(matrixArgs[1]);

        int[][] matrix = new int[rows][cols];

        String command = in.readLine();
        while (!"Here We Go".equals(command)) {
            String[] commandArgs = command.split("\\s+");

            int startRow = Integer.parseInt(commandArgs[0]);
            int startCol = Integer.parseInt(commandArgs[1]);
            int endRow = Integer.parseInt(commandArgs[2]);
            int endCol = Integer.parseInt(commandArgs[3]);


            for (int i = startRow; i <= endRow; i++) {
                for (int j = startCol; j <= endCol; j++) {
                    matrix[i][j]++;
                }
            }

            command = in.readLine();
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
