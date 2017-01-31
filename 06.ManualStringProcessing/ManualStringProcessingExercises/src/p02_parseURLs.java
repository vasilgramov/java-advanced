import java.util.Scanner;

public class p02_parseURLs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        String[] splittedInput = input.split("://");
        if (splittedInput.length != 2)
            System.out.println("Invalid URL");
        else {
            String protocol = String.format("Protocol = %s", splittedInput[0]);
            String server = String.format("Server = %s", splittedInput[1].substring(0, splittedInput[1].indexOf('/')));
            String resources = String.format("Resources = %s", splittedInput[1].substring(splittedInput[1].indexOf('/') + 1));

            System.out.println(protocol);
            System.out.println(server);
            System.out.println(resources);
        }
    }
}
