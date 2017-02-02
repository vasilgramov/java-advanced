import java.util.Scanner;

public class p02_stringLength {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int theLowestBoundary = 20;
        String input = in.nextLine();

        if (input.length() < 20) {
            int toAppend = 20 - input.length();
            input += newString(toAppend, "*");
            System.out.println(input);
        } else {
            System.out.println("a regular expression");
        }
    }

    private static String newString(int n, String str) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            builder.append("*");
        }

        return builder.toString();
    }
}
