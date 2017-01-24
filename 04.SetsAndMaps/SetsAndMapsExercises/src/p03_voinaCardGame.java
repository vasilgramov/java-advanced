import java.util.LinkedHashSet;
import java.util.Scanner;

public class p03_voinaCardGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayerCards = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondPlayerCards = new LinkedHashSet<>();

        for (int i = 0; i < 20; i++) {
            firstPlayerCards.add(in.nextInt());
        }

//        in.nextLine();

        for (int i = 0; i < 20; i++) {
            secondPlayerCards.add(in.nextInt());
        }

        for (int i = 0; i < 50; i++) {
            if (firstPlayerCards.isEmpty()) {
                System.out.println("Second player win!");
                return;
            } else if (secondPlayerCards.isEmpty()) {
                System.out.println("First player win!");
                return;
            }

            int firstPCard = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstPCard);
            int secondPCard = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondPCard);

            if (firstPCard == secondPCard)
                continue;
            if (firstPCard > secondPCard) {
                firstPlayerCards.add(firstPCard);
                firstPlayerCards.add(secondPCard);
            } else {
                secondPlayerCards.add(firstPCard);
                secondPlayerCards.add(secondPCard);
            }
        }

        if (firstPlayerCards.isEmpty())
            System.out.println("Second player win!");
        else if (secondPlayerCards.isEmpty())
            System.out.println("First player win!");
        else
            if (firstPlayerCards.size() == secondPlayerCards.size())
                System.out.println("Draw!");
            else
                if (firstPlayerCards.size() > secondPlayerCards.size())
                    System.out.println("First player win!");
                else
                    System.out.println("Second player win!");

    }
}
