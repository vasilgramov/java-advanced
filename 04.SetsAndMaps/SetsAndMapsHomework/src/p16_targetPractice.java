import java.util.Scanner;

public class p16_targetPractice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rows = in.nextInt();
        int cols = in.nextInt();

        in.nextLine();
        String text = in.nextLine();

        int impactRow = in.nextInt();
        int impactCol = in.nextInt();
        int radius = in.nextInt();

        char[][] matrix = new char[rows][cols];

        fillMatrix(rows, cols, text, matrix);

        explode(rows, cols, impactRow, impactCol, radius, matrix);

//        printMatrix(matrix);
//        System.out.println();

        for (int i = 0; i < cols; i++) {
            for (int j = rows - 2; j >= 0; j--) {
                if (matrix[j][i] != ' ') {
                    for (int k = j; k < rows - 1; k++) {
                        if (matrix[k + 1][i] == ' ') {
                            matrix[k + 1][i] = matrix[k][i];
                            matrix[k][i] = ' ';
                        } else {
                            break;
                        }
                    }
                }
            }
        }


        printMatrix(matrix);
    }

    private static void fillMatrix(int rows, int cols, String text, char[][] matrix) {
        boolean toTheLeft = true;
        int index = 0;
        for (int i = rows - 1; i >= 0; i--) {
            if (toTheLeft) {
                for (int j = cols - 1; j >= 0; j--) {
                    matrix[i][j] = text.charAt(index);

                    index++;
                    if (index == text.length())
                        index = 0;
                }

                toTheLeft = false;
            } else {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = text.charAt(index);

                    index++;
                    if (index == text.length())
                        index = 0;
                }

                toTheLeft = true;
            }
        }
    }

    private static void explode(int rows, int cols, int impactRow, int impactCol, int radius, char[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Math.pow((i - impactRow), 2) + Math.pow((j - impactCol), 2) <= Math.pow(radius, 2)) {
                    matrix[i][j] = ' ';
                }
            }
        }
    }

    static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "");
            }

            System.out.println();
        }
    }
}
