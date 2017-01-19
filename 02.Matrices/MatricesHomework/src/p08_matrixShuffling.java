import java.util.Scanner;

public class p08_matrixShuffling {
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

        String command = in.nextLine();
        while (!command.equals("END")) {
            String[] commandArgs = command.split("\\s+");
            if (commandArgs.length > 5 || commandArgs.length < 5 || !commandArgs[0].equals("swap")) {
                System.out.println("Invalid input!");
                command = in.nextLine();
                continue;
            }

            int fromRow = Integer.parseInt(commandArgs[1]);
            int fromCol = Integer.parseInt(commandArgs[2]);
            int toRow = Integer.parseInt(commandArgs[3]);
            int toCol = Integer.parseInt(commandArgs[4]);

            if (isInMatrix(fromRow, fromCol, rows, cols) && isInMatrix(toRow, toCol, rows, cols)) {
                String temp = matrix[fromRow][fromCol];
                matrix[fromRow][fromCol] = matrix[toRow][toCol];
                matrix[toRow][toCol] = temp;
            } else {
                System.out.println("Invalid input!");
                command = in.nextLine();
                continue;
            }

            printMatrix(matrix);

            command = in.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    private static boolean isInMatrix(int row, int col, int totalRows, int totalCols) {
        if (row >= 0 && row < totalRows && col >= 0 && col < totalCols) {
            return true;
        }

        return false;
    }
}
