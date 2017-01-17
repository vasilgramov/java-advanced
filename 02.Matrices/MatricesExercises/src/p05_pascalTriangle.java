import java.util.Scanner;

public class p05_pascalTriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        printPascalTriangle(n);
    }

    private static void printPascalTriangle(int n) {
        long[][] pascalTriangle = new long[n][];
        pascalTriangle[0] = new long[] { 1 };
        if (n == 1) {
            System.out.println(1);
            return;
        }
        pascalTriangle[1] = new long[] { 1, 1 };
        if (n == 2) {
            System.out.println("1 1");
            return;
        }

        for (int i = 2; i < n; i++) {
            long[] currentArray = new long[i + 1];
            currentArray[0] = 1;
            currentArray[currentArray.length - 1] = 1;

            for (int j = 1; j < currentArray.length - 1; j++) {
                currentArray[j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
            }

            pascalTriangle[i] = currentArray;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < pascalTriangle[i].length; j++) {
                System.out.print(pascalTriangle[i][j] + " ");
            }

            if (i == n - 1)
                return;

            System.out.println();
        }
    }
}
