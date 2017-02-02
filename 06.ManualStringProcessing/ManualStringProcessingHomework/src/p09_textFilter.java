import java.util.Scanner;

public class p09_textFilter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] wordsToBan = in.nextLine().split(",\\s+");
        String text = in.nextLine();

        for (String word : wordsToBan) {
            text = text.replaceAll(word, newString(word.length(), "*"));
        }

        System.out.println(text);
    }

    private static String newString(int n, String str) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            builder.append(str);
        }

        return builder.toString();
    }
}
