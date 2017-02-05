import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p08_sumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String keyString = in.readLine();
        String startKey = getStartKey(keyString).toString();
        String endKey = getEndKey(keyString).toString();

        String text = in.readLine();

        if (startKey.equals("") || endKey.equals("") || startKey.contains("*") || endKey.contains("*")) {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        Pattern pattern = Pattern.compile("^((?:\\d+)?(?:[.]\\d+)?)$");

        double sum = 0.0;
        while (text.contains(startKey)) {
            int start = text.indexOf(startKey) + startKey.length();
            int end = text.indexOf(endKey, start);

            String substr = text.substring(start, end);
            if (!substr.equals("")) {
                Matcher matcher = pattern.matcher(substr);
                if (matcher.find()) {
                    sum += Double.parseDouble(substr);
                }
            }

            text = text.substring(end + endKey.length());
        }

        if (sum == 0)
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        else {
            if (sum == (int)sum) {
                System.out.printf("<p>The total value is: <em>%d</em></p>", (int)sum);
            } else
                System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
        }
    }

    private static StringBuilder getEndKey(String keyString) {
        StringBuilder endKey = new StringBuilder();

        for (int i = keyString.length() - 1; i >= 0; i--) {
            if (!Character.isDigit(keyString.charAt(i)))
                endKey.append(keyString.charAt(i));
            else
                break;
        }

        endKey = endKey.reverse();
        return endKey;
    }

    private static StringBuilder getStartKey(String keyString) {
        StringBuilder startKey = new StringBuilder();

        for (int i = 0; i < keyString.length(); i++) {
            if (!Character.isDigit(keyString.charAt(i)))
                startKey.append(keyString.charAt(i));
            else
                break;
        }

        return startKey;
    }
}
