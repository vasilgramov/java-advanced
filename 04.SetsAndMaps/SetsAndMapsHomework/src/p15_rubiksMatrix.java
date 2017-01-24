import java.util.Scanner;

public class p15_rubiksMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rows = in.nextInt();
        int cols = in.nextInt();
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix);

        in.nextLine();
        int numberOfCommands = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandArgs = in.nextLine().split("\\s+");
            int rowOrCol = Integer.parseInt(commandArgs[0]);
            String direction = commandArgs[1];
            int moves = Integer.parseInt(commandArgs[2]);

            shuffleMatrix(matrix, rowOrCol, direction, moves);
        }

        int counter = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == counter) {
                    System.out.println("No swap required");
                    counter++;
                    continue;
                }

                outerLoop:
                for (int k = 0; k < matrix.length; k++) {
                    for (int l = 0; l < matrix[k].length; l++) {
                        if (matrix[k][l] == counter) {
                            System.out.printf("Swap (%d, %d) with (%d, %d)\n", i, j, k, l);
                            int temp = matrix[i][j];
                            matrix[i][j] = matrix[k][l];
                            matrix[k][l] = temp;
                            break outerLoop;
                        }
                    }
                }

                counter++;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    private static void shuffleMatrix(int[][] matrix, int rowOrCol, String direction, int moves) {
        if (direction.equals("right")) {    // col
            for (int i = 0; i < moves % matrix[rowOrCol].length; i++) {
                int lastElement = matrix[rowOrCol][matrix[rowOrCol].length - 1];
                for (int j = matrix[rowOrCol].length - 1; j >= 1; j--) {
                    matrix[rowOrCol][j] = matrix[rowOrCol][j - 1];
                }

                matrix[rowOrCol][0] = lastElement;
            }
        } else if (direction.equals("down")) {  // row
            for (int i = 0; i < moves % matrix.length; i++) {
                int lastElement = matrix[matrix.length - 1][rowOrCol];
                for (int j = matrix.length - 1; j >= 1; j--) {
                    matrix[j][rowOrCol] = matrix[j - 1][rowOrCol];
                }

                matrix[0][rowOrCol] = lastElement;
            }
        } else if (direction.equals("left")) {  // col
            for (int i = 0; i < moves % matrix[rowOrCol].length; i++) {
                int firstElement = matrix[rowOrCol][0];
                for (int j = 0; j < matrix[rowOrCol].length - 1; j++) {
                    matrix[rowOrCol][j] = matrix[rowOrCol][j + 1];
                }

                matrix[rowOrCol][matrix[rowOrCol].length - 1] = firstElement;
            }

        } else if (direction.equals("up")) {    // row
            for (int i = 0; i < moves % matrix.length; i++) {
                int firstElement = matrix[0][rowOrCol];
                for (int j = 0; j < matrix.length - 1; j++) {
                    matrix[j][rowOrCol] = matrix[j + 1][rowOrCol];
                }

                matrix[matrix.length - 1][rowOrCol] = firstElement;
            }
        }
    }

    private static void fillMatrix(int[][] matrix) {
        int num = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = num;
                num++;
            }
        }
    }
}
