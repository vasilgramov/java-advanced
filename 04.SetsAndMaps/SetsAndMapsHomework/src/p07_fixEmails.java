import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p07_fixEmails {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedHashMap<String, String> emailByName = new LinkedHashMap<>();
        String name = in.nextLine();
        while (!"stop".equals(name)) {
            String email = in.nextLine();
            if (!email.toLowerCase().endsWith("us")
                    && !email.toLowerCase().endsWith("uk")
                    && !email.toLowerCase().endsWith("com")) {
                emailByName.put(name, email);
            }

            name = in.nextLine();
        }

        for (Map.Entry<String, String> stringStringEntry : emailByName.entrySet()) {
            System.out.println(stringStringEntry.getKey() + " -> " + stringStringEntry.getValue());
        }
    }
}
