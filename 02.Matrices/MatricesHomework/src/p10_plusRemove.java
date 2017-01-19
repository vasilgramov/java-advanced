import java.util.ArrayList;
import java.util.Scanner;

public class p10_plusRemove {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();
        int rowCounter = 0;
        String command = in.nextLine();
        
        // building matrix
        while (!command.equals("END")) {
            matrix.add(rowCounter, new ArrayList<>());
            for (int i = 0; i < command.length(); i++) {
                matrix.get(rowCounter).add(command.charAt(i));
            }
            
            rowCounter++;
            command = in.nextLine();
        }

        ArrayList<Integer> indexToBeRemoved = new ArrayList<>();
        for (int i = 1; i < matrix.size() - 1; i++) {
            for (int j = 1; j < matrix.get(i).size() - 1; j++) {
                char currentCell = Character.toLowerCase(matrix.get(i).get(j));

                if (isInMatrix(j, matrix.get(i - 1).size()) && Character.toLowerCase(matrix.get(i - 1).get(j)) == currentCell &&
                        isInMatrix(j + 1, matrix.get(i).size()) && Character.toLowerCase(matrix.get(i).get(j + 1)) == currentCell &&
                        isInMatrix(j, matrix.get(i + 1).size()) && Character.toLowerCase(matrix.get(i + 1).get(j)) == currentCell &&
                        isInMatrix(j - 1, matrix.get(i).size()) && Character.toLowerCase(matrix.get(i).get(j - 1)) == currentCell) {
                    indexToBeRemoved.add(i);
                    indexToBeRemoved.add(j);
                }
            }
        }

        for (int i = 0; i < indexToBeRemoved.size(); i += 2) {
            int row = indexToBeRemoved.get(i);
            int col = indexToBeRemoved.get(i + 1);

            matrix.get(row).set(col, null);
            matrix.get(row - 1).set(col, null);
            matrix.get(row).set(col + 1, null);
            matrix.get(row + 1).set(col, null);
            matrix.get(row).set(col - 1, null);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(ArrayList<ArrayList<Character>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) == null) {
                    System.out.print("");
                } else {
                    System.out.print(matrix.get(i).get(j));
                }
            }

            System.out.println();
        }
    }

    private static boolean isInMatrix(int col, int totalCols) {
        if (col>= 0 && col < totalCols) {
            return true;
        }

        return false;
    }
}
