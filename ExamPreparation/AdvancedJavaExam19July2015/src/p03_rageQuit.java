import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03_rageQuit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        Pattern pattern = Pattern.compile("(.+?)([0-9]+)");
        Matcher matcher = pattern.matcher(input);

        Set<Character> uniqueSymbols = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        while (matcher.find()) {
            String text = matcher.group(1).toUpperCase();
            int repetition = Integer.parseInt(matcher.group(2));

            if (repetition > 0) {
                for (int i = 0; i < text.length(); i++) {
                    uniqueSymbols.add(text.charAt(i));
                }
            }

            for (int i = 0; i < repetition; i++) {
                builder.append(text);
            }
        }

//        System.out.println(uniqueSymbols);

        System.out.println("Unique symbols used: " + uniqueSymbols.size());
        System.out.println(builder);

    }
}
