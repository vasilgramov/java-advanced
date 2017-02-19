import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new HashMap<>();

        Pattern pattern = Pattern.compile("(\\,|\\_)([a-zA-Z0-9]+)(?<![0-9])([0-9])");

        String command = in.readLine().trim();
        while (!"Ascend".equals(command)) {
            Matcher matcher = pattern.matcher(command);

            while (matcher.find()) {
                boolean shouldAdd = true;

                String commaUnderscore = matcher.group(1);
                if (!commaUnderscore.equals(",") && !commaUnderscore.equals("_"))
                    throw new Exception();

                char[] message = matcher.group(2).toCharArray();
                int digit = Integer.parseInt(matcher.group(3));

                String search = commaUnderscore + new String(message) + digit;
                if (map.containsKey(search)) {
                    String newPattern = map.get(search);
                    command = command.replace(search, newPattern);

                    map.put(search, newPattern);

                    matcher = pattern.matcher(command);
                    continue;
                }


                String messageAsString = commaUnderscore + new String(message) + digit;
                if (map.containsKey(messageAsString)) {
                    message = map.get(messageAsString).toCharArray();
                    shouldAdd = false;
                }

                if (commaUnderscore.equals(",")) {
                    processMessage(message, digit);
                } else {
                    processMessage(message, -digit);
                }

                String toReplace = matcher.group();
                if (shouldAdd) {
                    map.put(toReplace, new String(message));
                }

                command = command.replace(matcher.group(), new String(message));

                matcher = pattern.matcher(command);
            }


            System.out.println(command);

            command = in.readLine();
        }
    }

    private static void processMessage(char[] message, int digit) {
        for (int i = 0; i < message.length; i++) {
            message[i] += digit;
        }
    }
}
