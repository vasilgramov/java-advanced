import java.util.Arrays;
import java.util.Scanner;

public class p17_legoBlock {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        String[][] firstMatrix = new String[n][];
        String[][] secondMatrix = new String[n][];

        int firstMatrixCells = 0;
        int secondMatrixCells = 0;

        for (int i = 0; i < n; i++) {
            String currentRow = in.nextLine().trim();
            String[] elements = currentRow.split("\\s+");
            firstMatrix[i] = new String[elements.length];
            firstMatrixCells += elements.length;
            for (int j = 0; j < elements.length; j++) {
                firstMatrix[i][j] = elements[j];
            }
        }

        for (int i = 0; i < n; i++) {
            String currentRow = in.nextLine().trim();
            String[] elements = currentRow.split("\\s+");
            secondMatrix[i] = new String[elements.length];
            secondMatrixCells += elements.length;
            for (int j = 0; j < elements.length; j++) {
                secondMatrix[i][j] = elements[j];
            }
        }

        int numberOfElements = firstMatrix[0].length + secondMatrix[0].length;  // check if n == 0
        for (int i = 1; i < n; i++) {
            int currentNumberOfElements = firstMatrix[i].length + secondMatrix[i].length;
            if (currentNumberOfElements != numberOfElements) {
                System.out.println("The total number of cells is: " + (firstMatrixCells + secondMatrixCells));
                return;
            }
        }

        String[][] combinedMatrix =  new String[n][numberOfElements];
        for (int i = 0; i < n; i++) {
            int index = 0;

            for (int j = 0; j < firstMatrix[i].length; j++) {
                combinedMatrix[i][index] = firstMatrix[i][j];
                index++;
            }

            for (int j = secondMatrix[i].length - 1; j >= 0; j--) {
                combinedMatrix[i][index] = secondMatrix[i][j];
                index++;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print("[");
            boolean isFirst = true;

            for (int j = 0; j < numberOfElements; j++) {
                if (!combinedMatrix[i][j].equals(" ")) {
                    if (isFirst) {
                        System.out.print(combinedMatrix[i][j]);
                        isFirst = false;
                    } else {
                        System.out.print(", " + combinedMatrix[i][j]);
                    }
                }
            }

            System.out.println("]");
        }
    }
}
