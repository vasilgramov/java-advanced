import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p16_extractHyperlinks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StringBuilder builder = new StringBuilder();

        String command = in.nextLine();
        while (!"END".equals(command)) {
            builder.append(command);
            command = in.nextLine();
        }

        String str = "<a\\s+([^>]+\\s+)?href\\s*=\\s*('([^']*)'|\\\"([^\\\"]*)|([^\\\\s>]+))[^>]*>";
        Pattern pattern = Pattern.compile(str);
        Matcher m = pattern.matcher(builder);
        while (m.find()) {
            for (int i = 5; i >= 0; i--) {
                if (m.group(i) != null) {
                    System.out.println(m.group(i));
                    break;
                }
            }
        }
    }
}
