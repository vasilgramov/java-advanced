import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p12_semanticHTML {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Pattern openingTag = Pattern.compile("<\\s*div.*(?:id|class)\\s*=\\s*\"(.+?)\"");

        String input = in.readLine();
        while (!"END".equals(input)) {
            Matcher openingMatcher = openingTag.matcher(input);

            int whiteSpaces = getStartingWhiteSpaces(input);
            StringBuilder toPrint = new StringBuilder(newString(whiteSpaces, " "));

            if (openingMatcher.find()) {
                toPrint.append("<" + openingMatcher.group(1));
            }

            System.out.println(toPrint);

            input = in.readLine();
        }
    }

    private static String newString(int whiteSpaces, String str) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < whiteSpaces; i++) {
            builder.append(" ");
        }

        return builder.toString();
    }

    private static int getStartingWhiteSpaces(String input) {
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                counter++;
            } else {
                break;
            }
        }

        return counter;
    }
}
