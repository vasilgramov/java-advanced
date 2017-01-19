import java.util.ArrayList;
import java.util.Scanner;

public class p06_maxSequenceInMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rows = in.nextInt();
        int cols = in.nextInt();
        in.nextLine();

        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] currentLine = in.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = currentLine[j];
            }
        }


        ArrayList<String> sequence = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int currentRow = i;
                int currentCol = j;
                String currentCell = matrix[currentRow][currentCol];
                ArrayList<String> currentSequence = new ArrayList<>();

                while (true) {
                    if (isInMatrix(currentRow, currentCol, rows, cols) && matrix[currentRow][currentCol].equals(currentCell)) {
                        currentSequence.add(matrix[currentRow][currentCol]);
                    } else {
                        break;
                    }

                    currentRow++;
                }

                currentRow = i;
                currentCol = j;
                if (currentSequence.size() > sequence.size()) {
                    sequence = new ArrayList<>(currentSequence);
                }

                currentSequence = new ArrayList<>();
                while (true) {
                    if (isInMatrix(currentRow, currentCol, rows, cols) && matrix[currentRow][currentCol].equals(currentCell)) {
                        currentSequence.add(matrix[currentRow][currentCol]);
                    } else {
                        break;
                    }

                    currentCol++;
                }

                currentRow = i;
                currentCol = j;
                if (currentSequence.size() > sequence.size()) {
                    sequence = new ArrayList<>(currentSequence);
                }

                currentSequence = new ArrayList<>();
                while (true) {
                    if (isInMatrix(currentRow, currentCol, rows, cols) && matrix[currentRow][currentCol].equals(currentCell)) {
                        currentSequence.add(matrix[currentRow][currentCol]);
                    } else {
                        break;
                    }

                    currentRow++;
                    currentCol++;
                }

                currentRow = i;
                currentCol = j;
                if (currentSequence.size() > sequence.size()) {
                    sequence = new ArrayList<>(currentSequence);
                }

                currentSequence = new ArrayList<>();
                while (true) {
                    if (isInMatrix(currentRow, currentCol, rows, cols) && matrix[currentRow][currentCol].equals(currentCell)) {
                        currentSequence.add(matrix[currentRow][currentCol]);
                    } else {
                        break;
                    }

                    currentRow--;
                }

                currentRow = i;
                currentCol = j;
                if (currentSequence.size() >= sequence.size()) {
                    sequence = new ArrayList<>(currentSequence);
                }

//                currentSequence = new ArrayList<>();
//                while (true) {
//                    if (isInMatrix(currentRow, currentCol, rows, cols) && matrix[currentRow][currentCol].equals(currentCell)) {
//                        currentSequence.add(matrix[currentRow][currentCol]);
//                    } else {
//                        break;
//                    }
//
//                    currentCol--;
//                }
//
//                currentRow = i;
//                currentCol = j;
//                if (currentSequence.size() >= sequence.size()) {
//                    sequence = new ArrayList<>(currentSequence);
//                }
//
//                currentSequence = new ArrayList<>();
//                while (true) {
//                    if (isInMatrix(currentRow, currentCol, rows, cols) && matrix[currentRow][currentCol].equals(currentCell)) {
//                        currentSequence.add(matrix[currentRow][currentCol]);
//                    } else {
//                        break;
//                    }
//
//                    currentRow--;
//                    currentCol--;
//                }
//
//                currentRow = i;
//                currentCol = j;
//                if (currentSequence.size() >= sequence.size()) {
//                    sequence = new ArrayList<>(currentSequence);
//                }
            }
        }

        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i) + ", ");
        }
    }

    private static boolean isInMatrix(int currentRow, int currentCol, int rows, int cols) {
        boolean isInRow = currentRow >= 0 && currentRow < rows;
        boolean isInCol = currentCol >= 0 && currentCol < cols;

        return isInRow && isInCol;
    }
}
