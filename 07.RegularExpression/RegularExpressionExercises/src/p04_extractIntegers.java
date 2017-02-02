import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p04_extractIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(in.readLine());

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
