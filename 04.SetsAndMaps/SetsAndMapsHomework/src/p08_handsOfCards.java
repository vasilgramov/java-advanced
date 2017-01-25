import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p08_handsOfCards {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedHashMap<String, HashSet<String>> cardsByPlayer = new LinkedHashMap<>();

        String command = in.nextLine();
        while (!"JOKER".equals(command)) {
            String[] commandArgs = command.split(":");
            String name = commandArgs[0].trim();
            String cards = commandArgs[1].trim();
            String[] splittedCards = cards.split(",\\s+");

            if (!cardsByPlayer.containsKey(name)) {
                cardsByPlayer.put(name, new HashSet<>());
            }

            HashSet<String> currentHashSet = cardsByPlayer.get(name);
            for (String card : splittedCards) {
                currentHashSet.add(card);
            }

            cardsByPlayer.put(name, currentHashSet);

            command = in.nextLine();
        }

        for (Map.Entry<String, HashSet<String>> stringHashSetEntry : cardsByPlayer.entrySet()) {
            String name = stringHashSetEntry.getKey();
            HashSet<String> cards = stringHashSetEntry.getValue();

            int score = calculatePoints(cards);

            System.out.println(name + ": " + score);
        }
    }

    private static int calculatePoints(HashSet<String> cards) {
        int score = 0;

        for (String card : cards) {
            String face = card.substring(0, card.length() - 1);
            String color = card.substring(card.length() - 1, card.length());

            int facePower = 0;
            int colorPower = 0;

            switch (face) {
                case "2":
                    facePower = 2;
                    break;
                case "3":
                    facePower = 3;
                    break;
                case "4":
                    facePower = 4;
                    break;
                case "5":
                    facePower = 5;
                    break;
                case "6":
                    facePower = 6;
                    break;
                case "7":
                    facePower = 7;
                    break;
                case "8":
                    facePower = 8;
                    break;
                case "9":
                    facePower = 9;
                    break;
                case "10":
                    facePower = 10;
                    break;
                case "J":
                    facePower = 11;
                    break;
                case "Q":
                    facePower = 12;
                    break;
                case "K":
                    facePower = 13;
                    break;
                case "A":
                    facePower = 14;
                    break;
            }

            switch (color) {
                case "S":
                    colorPower = 4;
                    break;
                case "H":
                    colorPower = 3;
                    break;
                case "D":
                    colorPower = 2;
                    break;
                case "C":
                    colorPower = 1;
                    break;
            }

            score += facePower * colorPower;
        }

        return score;
    }
}
