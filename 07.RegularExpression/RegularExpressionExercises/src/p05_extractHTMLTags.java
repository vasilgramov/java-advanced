import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p05_extractHTMLTags {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("<(.+?)>");

        String input = in.readLine();
        while (!input.equals("END")) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find())
                System.out.println(matcher.group());

            input = in.readLine();
        }
    }
}
