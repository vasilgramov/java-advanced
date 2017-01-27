import java.util.ArrayList;
import java.util.Scanner;

public class p19_crossFire {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rows = in.nextInt();
        int cols = in.nextInt();

        in.nextLine();

        int[][] matrix = new int[rows][cols];

        int counter = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = counter;
                counter++;
            }
        }

//        printMatrix(matrix);
        String command = in.nextLine();
        while (!"Nuke it from orbit".equals(command)) {
            String[] commandArgs = command.split("\\s+");
            int targetRow = Integer.parseInt(commandArgs[0]);
            int targetCol = Integer.parseInt(commandArgs[1]);
            int radius = Integer.parseInt(commandArgs[2]);

            if (targetRow >= 0 && targetRow < rows && targetCol >= 0 && targetCol < cols) {
                matrix[targetRow][targetCol] = -1;
            }

            for (int i = 1; i <= radius; i++) {
                if (isInMatrix(targetRow - i, targetCol, rows, cols)) {
                    matrix[targetRow - i][targetCol] = -1;
                }

                if (isInMatrix(targetRow, targetCol + i, rows, cols)) {
                    matrix[targetRow][targetCol + i] = -1;
                }

                if (isInMatrix(targetRow + i, targetCol, rows, cols)) {
                    matrix[targetRow + i][targetCol] = -1;
                }

                if (isInMatrix(targetRow, targetCol - i, rows, cols)) {
                    matrix[targetRow][targetCol - i] = -1;
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    if (matrix[i][j] != -1) {
                        for (int k = j; k >= 1; k--) {
                            if (matrix[i][k - 1] == -1) {
                                matrix[i][k - 1] = matrix[i][k];
                                matrix[i][k] = -1;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }

            ArrayList toBeRebuilt = toRebuild(matrix);
            if (toBeRebuilt.size() > 0) {
                int newMatrixRows = matrix.length - toBeRebuilt.size();
                int[][] newMatrix = new int[newMatrixRows][cols];
                int newMatrixRowCounter = 0;
                for (int i = 0; i < matrix.length; i++) {
                    if (toBeRebuilt.contains(i))
                        continue;

                    for (int j = 0; j < matrix[i].length; j++) {
                        newMatrix[newMatrixRowCounter][j] = matrix[i][j];
                    }

                    newMatrixRowCounter++;
                }

                matrix = newMatrix;
                rows = newMatrixRows;
            }

            command = in.nextLine();
        }

        printMatrix(matrix);
    }

    private static ArrayList<Integer> toRebuild(int[][] matrix) {
        /* Returns an integer indicating if we need to rebuild the matrix.
        * Matrix needs to be rebuilt if a given row is completely empty */
        ArrayList<Integer> emptyRows = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            if (isEmpty(matrix, row)) {
                emptyRows.add(row);
            }
        }

        return emptyRows;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            boolean hasFound = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == - 1)
                    System.out.print("");
                else {
                    System.out.print(matrix[i][j] + " ");
                    hasFound = true;
                }
            }

            if (hasFound)
                System.out.println();
        }
    }

    private static boolean isEmpty(int[][] matrix, int row) {
        for (int col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] != -1)
                return false;
        }

        return true;
    }

    private static boolean isInMatrix(int row, int col, int rows, int cols) {
        if (row >= 0 && row < rows && col >= 0 && col < cols)
            return true;

        return false;
    }
}
