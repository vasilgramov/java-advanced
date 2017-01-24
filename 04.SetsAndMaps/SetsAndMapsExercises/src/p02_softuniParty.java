import java.util.Scanner;
import java.util.TreeSet;

public class p02_softuniParty {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeSet<String> guests = new TreeSet<>();
        String command = in.nextLine();
        while (!"PARTY".equals(command)) {
            guests.add(command);

            command = in.nextLine();
        }

        command = in.nextLine();
        while (!"END".equals(command)) {
            guests.remove(command);

            command = in.nextLine();
        }

        System.out.println(guests.size());
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
