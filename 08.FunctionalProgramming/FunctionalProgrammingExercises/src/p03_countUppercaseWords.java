import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Predicate;

public class p03_countUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Predicate<String> isStartingWithUppercase = str -> str.charAt(0) == Character.toUpperCase(str.charAt(0));

        String string = in.readLine();
        if (string.length() == 0) {
            return;
        }

        String[] input = string.split("\\s+");

        ArrayList<String> words = new ArrayList<>();
        for (String str : input) {
            String newStr = str.trim();
            if (newStr.length() == 0)
                continue;
            if (isStartingWithUppercase.test(str.trim())) {
                words.add(str);
            }
        }

        System.out.println(words.size());
        for (String word : words) {
            System.out.println(word);
        }
    }
}
