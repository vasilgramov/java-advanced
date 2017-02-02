import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p02_vowelCount {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("[AUOIEYauoiey]");
        String text = in.readLine();
        Matcher matcher = pattern.matcher(text);

        int counter = 0;
        while (matcher.find()) {
            System.out.println(matcher.group());
            counter++;
        }

        System.out.println("Vowels: " + counter);
    }
}
