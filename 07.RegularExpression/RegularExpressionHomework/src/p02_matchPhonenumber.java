import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p02_matchPhonenumber {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^\\+359( |-)2\\1\\d{3}\\1\\d{4}$");
        String input = in.readLine();
        while (!"end".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.println(input);
            }

            input = in.readLine();
        }
    }
}
