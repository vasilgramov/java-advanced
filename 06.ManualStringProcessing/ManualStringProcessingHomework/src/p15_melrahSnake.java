import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15_melrahSnake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        String pattern = reader.readLine();
        StringBuilder patternBuilder = new StringBuilder(pattern);

        while (pattern.length() > 0 && pattern.length() < text.length()) {
            int firstIndex = text.indexOf(pattern);
            int lastIndex = text.lastIndexOf(pattern);

            if (firstIndex != -1 && lastIndex != -1) {
                StringBuilder sb = new StringBuilder(text);
                sb.replace(firstIndex,pattern.length() + firstIndex,"");
                sb.replace(lastIndex - pattern.length(),pattern.length() + (lastIndex - pattern.length()),"");

                text = sb.toString();
                patternBuilder.deleteCharAt(pattern.length() / 2);
                pattern = patternBuilder.toString();
                System.out.println("Shaked it.");
            } else {
                break;
            }
        }

        System.out.println("No shake.");
        System.out.println(text);
    }
}
