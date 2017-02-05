import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p09_validUsernames {
    static String str1 = "";
    static String str2 = "";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String firstUsername = new String();
        String secondUsername = new String();

        String[] input = in.readLine().split("\\\\\\s*|\\/\\s*|\\(\\s*|\\)\\s*|\\s+");

        Pattern pattern = Pattern.compile("^[A-Za-z]\\w{2,24}$");
        for (String username : input) {
            if (input.equals(""))
                continue;

            Matcher matcher = pattern.matcher(username);

            if (matcher.find()) {
                if (str1.equals("")) {
                    str1 = username;
                    continue;
                }

                if (!str1.equals("") && str2.equals("")) {
                    str2 = username;
                }

                if ((!str1.equals("") && !str2.equals("")) && (str1.length() + str2.length() > firstUsername.length() + secondUsername.length())) {
                    firstUsername = new String(str1);
                    secondUsername = new String(str2);
                }

                if (!str1.equals("") && !str2.equals("")) {
                    str1 = new String(str2);
                    str2 = new String();
                }
            }
        }

        System.out.println(firstUsername);
        System.out.println(secondUsername);
    }
}
