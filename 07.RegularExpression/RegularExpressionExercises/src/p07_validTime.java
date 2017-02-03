import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p07_validTime {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        String[] inputs = { "12:33:24 AM", "33:12:11 PM", "inv 23:52:34 AM", "00:13:23 PM", "9:3:12 АМ", "END" };
        int index = 0;
        while (!"END".equals(inputs[index])) {
            String result = isValid(inputs[index]);
            System.out.println(result);

            index++;
        }
    }

    public static String isValid(String input) {
        Pattern pattern = Pattern.compile("^(?:[1][1-2]|[0][1-9]):[0-5][0-9]:[0-5][0-9]\\s(?:AM|PM)$");

        Matcher matcher = pattern.matcher(input);

        if (matcher.find())
            return "valid";

        return "invalid";
    }
}
