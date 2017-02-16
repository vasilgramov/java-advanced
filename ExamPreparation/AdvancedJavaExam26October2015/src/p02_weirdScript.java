import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p02_weirdScript {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String key = "";
        int keyValue = Integer.parseInt(in.nextLine()) % 52;

        if (keyValue == 0)
            keyValue = 52;

        if (keyValue < 27) {
            key += (char)(96 + keyValue);
        } else {
            key += (char)(64 + (keyValue - 26));
        }

        key += key;

        Pattern pattern = Pattern.compile(Pattern.quote(key) + "(.*?)" + Pattern.quote(key));

        StringBuilder builder = new StringBuilder();
        String line = in.nextLine();
        while (!line.equals("End")) {
            builder.append(line);

            line = in.nextLine();
        }

        Matcher matcher = pattern.matcher(builder);
        while (matcher.find()) {
            if (matcher.group(1).equals(""))
                continue;
            System.out.println(matcher.group(1));
        }
    }
}
