import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p11_stringMatrixRotations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] commandArgs = in.nextLine().split("\\(|\\)");
        ArrayList<String> matrix = new ArrayList<>();

        String command = in.nextLine();
        int longestRow = 0;
        while (!command.equals("END")) {
            if (command.length() > longestRow)
                longestRow = command.length();

            matrix.add(command);

            command = in.nextLine();
        }

        int angle = Integer.parseInt(commandArgs[1]);

        switch (angle % 360) {
            case 90:
                for (int i = 0; i < longestRow; i++) {
                    for (int j = matrix.size() - 1; j >= 0; j--) {
                        if (i >= matrix.get(j).length())
                            System.out.printf(" ");
                        else
                            System.out.print(matrix.get(j).charAt(i));
                    }

                    System.out.println();
                }
                break;
            case 180:
                for (int i = matrix.size() - 1; i >= 0; i--) {
                    String toPrint = new StringBuilder(matrix.get(i)).reverse().toString();
                    System.out.println(padLeft(toPrint, longestRow));
                }
                break;
            case 270:
                for (int i = longestRow - 1; i >= 0; i--) {
                    for (int j = 0; j < matrix.size(); j++) {
                        if (i >= matrix.get(j).length())
                            System.out.print(" ");
                        else
                            System.out.print(matrix.get(j).charAt(i));
                    }

                    System.out.println();
                }
                break;
            case 0:
                for (int i = 0; i < matrix.size(); i++) {
                    System.out.println(matrix.get(i));
                }
                break;
        }
    }

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }
}
