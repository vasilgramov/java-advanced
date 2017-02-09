import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p06_findAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = in.readLine().split("\\s+");
        OptionalInt min = Arrays.stream(tokens)
                .filter(x -> !x.isEmpty())
                .filter(x -> isNumber(x))
                .mapToInt(x -> Integer.parseInt(x))
                .reduce((x, y) -> x + y);

        if (min.isPresent()) System.out.println(min.getAsInt());
        else System.out.println("No match");
    }

    private static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("^(\\+|\\-)?\\d+$");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find())
            return true;

        return false;
    }
}
