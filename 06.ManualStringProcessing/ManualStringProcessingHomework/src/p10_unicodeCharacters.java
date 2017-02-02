import java.util.Scanner;

public class p10_unicodeCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StringBuilder builder = new StringBuilder();
        String input = in.nextLine();
        for (int i = 0; i < input.length(); i++) {
            StringBuilder toApped = new StringBuilder("\\u" + Integer.toHexString(input.charAt(i)));
            while (toApped.length() < 6) {
                toApped.insert(2, "0");
            }
            builder.append(toApped);
        }

        System.out.println(builder);
    }
}
