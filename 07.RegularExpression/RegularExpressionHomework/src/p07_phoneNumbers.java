import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p07_phoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, String> phoneNumberByName = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("([A-Z](?:[a-zA-Z]+)?)([^a-zA-Z+]*[+]?[0-9]+[()\\/.\\- ]*[0-9]+(?:[()\\/.\\- ]+[0-9]+)*)");
        String input = in.readLine();

        StringBuilder allInputs = new StringBuilder();
        while (!"END".equals(input)) {
            allInputs.append(input);

            input = in.readLine();
        }

        Matcher matcher = pattern.matcher(allInputs);
        while (matcher.find()) {
            String name = matcher.group(1);
            String number = matcher.group(2);

            String clearedNumber = clearNumber(number);

            phoneNumberByName.put(name, clearedNumber);
        }

        if (phoneNumberByName.isEmpty())
            System.out.println("<p>No matches!</p>");
        else {
            StringBuilder result = new StringBuilder();
            result.append("<ol>");

            for (Map.Entry<String, String> stringStringEntry : phoneNumberByName.entrySet()) {
                result.append("<li>");
                result.append("<b>");
                result.append(stringStringEntry.getKey());
                result.append(":</b> ");
                result.append(stringStringEntry.getValue());
                result.append("</li>");
            }

            result.append("</ol>");
            System.out.println(result);
        }
    }

    private static String clearNumber(String number) {
        StringBuilder clearedNumber = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '+') {
                clearedNumber.append("+");
                continue;
            }

            if (Character.isDigit(number.charAt(i))) {
                clearedNumber.append(number.charAt(i));
            }
        }

        return clearedNumber.toString();
    }
}
