import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p03_seriesOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder input = new StringBuilder(in.readLine());
        StringBuilder result = new StringBuilder();
        result.append(input.charAt(0));
        int lastIndex = 0;
        for (int i = 1; i < input.length(); i++) {
            if (result.charAt(lastIndex) != input.charAt(i)) {
                result.append(input.charAt(i));
                lastIndex++;
            }
        }

        System.out.println(result);
    }
}
