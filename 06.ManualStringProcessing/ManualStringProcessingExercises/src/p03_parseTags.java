import java.util.Scanner;

public class p03_parseTags {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();


        while (input.contains("<upcase>")) {
            int startIndex = input.indexOf("<upcase>");
            int endIndex = input.indexOf("</upcase>");

            String toUp = input.substring(startIndex + 8, endIndex);

            input = input.replaceFirst(toUp, toUp.toUpperCase());

            input = input.replaceFirst("<upcase>", "");
            input = input.replaceFirst("</upcase>", "");

        }

        System.out.println(input);
    }
}
