import java.util.*;

public class p02_jediGalaxy {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] matrixArgs = in.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixArgs[0]);
        int cols = Integer.parseInt(matrixArgs[1]);

        long count = 0;
        long[][] matrix = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = count;
                count++;
            }
        }

        Set<Long> eviPath = new HashSet<>();

        long totalSum = 0L;
        String command = in.nextLine();
        while (!"Let the Force be with you".equals(command)) {
            String[] ivoCoordinates = command.split("\\s+");
            String[] evilCoordinates = in.nextLine().split("\\s+"); // check
            if (evilCoordinates[0].equals("Let"))
                break;

            int jediRow = Integer.parseInt(ivoCoordinates[0]);
            int jediCol = Integer.parseInt(ivoCoordinates[1]);

            int evilRow = Integer.parseInt(evilCoordinates[0]);
            int evilCol = Integer.parseInt(evilCoordinates[1]);


            // process the dark path
            if (evilRow >= rows) {
                int shiftValue = evilRow - rows + 1;
                evilRow -= shiftValue;
                evilCol -= shiftValue;
            }

            if (evilCol >= cols) {
                int shiftValue = evilCol - cols + 1;
                evilRow -= shiftValue;
                evilCol -= shiftValue;
            }
            //-----------------------------------------------------------------------------

            while (evilRow >= 0 && evilCol >= 0) {
                matrix[evilRow][evilCol] = 0;
                evilRow--;
                evilCol--;
            }

            //process the jedi path
            if (jediRow >= rows) {
                int shiftValue = jediRow - rows + 1;
                jediRow -= shiftValue;
                jediCol += shiftValue;
            }

            if (jediCol < 0) {
                int shiftValue = Math.abs(jediCol);
                jediRow -= shiftValue;
                jediCol += shiftValue;
            }
            //-----------------------------------------------------------------------------


            while (evilRow >= 0 && evilCol >= 0) {
                if (isInMatirx(evilRow, evilCol, rows, cols))
                    eviPath.add(matrix[evilRow][evilCol]);

                evilRow--;
                evilCol--;
            }

            while (jediRow >= 0 && jediCol < cols) {
                if (isInMatirx(jediRow, jediCol, rows, cols) && !eviPath.contains(matrix[jediRow][jediCol]))
                    totalSum += matrix[jediRow][jediCol];

                jediRow--;
                jediCol++;
            }

            command = in.nextLine();
        }

        System.out.println(totalSum);
    }

    private static boolean isInMatirx(int row, int col, int totalRows, int totalCols) {
        if (row >= 0 && row < totalRows && col >= 0 && col < totalCols)
            return true;

        return false;
    }
}
