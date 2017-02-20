import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("(\\,|\\_)([a-zA-Z0-9]+)(?<![0-9])([0-9])");

        String command = in.readLine().trim();
        while (!"Ascend".equals(command)) {

            for (String str : map.keySet()) {
                command = command.replaceAll(str, map.get(str));
            }

            Matcher matcher = pattern.matcher(command);
            while (matcher.find()) {
                String commaUnderscore = matcher.group(1);
                String message = matcher.group(2);
                int digit = Integer.parseInt(matcher.group(3));

                String wholeMatch = matcher.group(0);

                String newWord = "";
                if (commaUnderscore.equals(",")) {
                    newWord = processMessage(message, digit);
                } else {
                    newWord = processMessage(message, -digit);
                }

                command = command.replaceAll(wholeMatch, newWord);

                map.put(wholeMatch, newWord);
            }

            System.out.println(command);

            command = in.readLine();

        }
    }

    private static String processMessage(String message, int digit) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            builder.append(Character.toString((char)(message.charAt(i) + digit)));
        }

        return builder.toString();
    }
}
