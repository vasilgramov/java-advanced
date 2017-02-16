import java.util.Scanner;

public class p01_tinySporebat {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int health = 5800;
        int coins = 0;

        String line = in.nextLine();
        while (!line.equals("Sporeggar")) {
            int damage = 0;

            for (int i = 0; i < line.length() - 1; i++) {
                if (line.charAt(i) == 'L')
                    health += 200;
                else
                    damage += line.charAt(i);
            }

            health -= damage;
            if (health <= 0) {
                System.out.println("Died. Glowcaps: " + coins);
                return;
            }

            coins += Integer.parseInt(Character.toString(line.charAt(line.length() - 1)));

            line = in.nextLine();
        }

        System.out.println("Health left: " + health);
        if (coins >= 30) {
            System.out.println("Bought the sporebat. Glowcaps left: " + (coins - 30));
        } else {
            int needed = 30 - coins;
            System.out.println("Safe in Sporeggar, but another " + needed + " Glowcaps needed.");
        }
    }
}
