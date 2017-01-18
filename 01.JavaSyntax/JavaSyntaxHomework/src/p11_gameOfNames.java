import java.util.HashMap;
import java.util.Scanner;

public class p11_gameOfNames {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfPlayers = Integer.parseInt(in.nextLine());
        String winnersName = "";
        long winnersPoints = Long.MIN_VALUE;
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = in.nextLine();
            long points = Integer.parseInt(in.nextLine());

            for (int j = 0; j < name.length(); j++) {
                int currentSymbol = name.charAt(j);

                if (currentSymbol % 2 == 0)
                    points += currentSymbol;
                else
                    points -= currentSymbol;
            }

            if (points > winnersPoints) {
                winnersName = name;
                winnersPoints = points;
            }
        }

        System.out.printf("The winner is %s - %d points", winnersName, winnersPoints);
    }
}
