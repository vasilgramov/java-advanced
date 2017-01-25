import java.util.HashMap;
import java.util.Scanner;

public class p05_phonebook {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HashMap<String, String> numberByName = new HashMap<>();

        String command = in.nextLine();
        while (!"search".equals(command)) {
            String[] commandArgs = command.split("-");
            String name = commandArgs[0];
            String number = commandArgs[1];

            numberByName.put(name, number);

            command = in.nextLine();
        }

        command = in.nextLine();
        while (!"stop".equals(command)) {
            if (numberByName.containsKey(command)) {
                System.out.println(command + " -> " + numberByName.get(command));
            } else {
                System.out.println("Contact " + command + " does not exist.");
            }

            command = in.nextLine();
        }
    }
}
