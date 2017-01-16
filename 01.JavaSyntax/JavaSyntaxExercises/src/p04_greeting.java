import java.util.Scanner;

public class p04_greeting {
    static final String DEFAULT_NAME = "*****";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String firstStr = in.nextLine();
        String secondStr = in.nextLine();

        String firstName = firstStr.isEmpty() ? DEFAULT_NAME : firstStr;
        String secondName = secondStr.isEmpty() ? DEFAULT_NAME : secondStr;

        System.out.printf("Hello, %s %s!", firstName, secondName);
    }
}
