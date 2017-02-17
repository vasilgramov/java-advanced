import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p03_royalFlush {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        List<String> cards = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String currentLine = in.readLine();

            for (int j = 0; j < currentLine.length(); j += 2) {
                String currentCard = currentLine.charAt(j) + "" + currentLine.charAt(j + 1);
                if (currentCard.equals("10")) {
                    currentCard += currentLine.charAt(j + 2);
                    j += 1;
                }

                cards.add(currentCard);
            }
        }

        int count = 0;
        for (int i = 0; i < cards.size(); i++) {
            String currentCard = cards.get(i);
            char suit = currentCard.charAt(currentCard.length() - 1);

            String searchedJack = "J" + suit;
            String searchedQueen = "Q" + suit;
            String searchedKing = "K" + suit;
            String searchedAce = "A" + suit;

            if (currentCard.startsWith("10")) {
                outerLoop:
                for (int j = i + 1; j < cards.size(); j++) {
                    if (cards.get(j).charAt(cards.get(j).length() - 1) == suit && !cards.get(j).equals(searchedJack))
                        break outerLoop;

                    if (cards.get(j).equals(searchedJack)) {
                        for (int k = j + 1; k < cards.size(); k++) {
                            if (cards.get(k).charAt(cards.get(k).length() - 1) == suit && !cards.get(k).equals(searchedQueen))
                                break outerLoop;

                            if (cards.get(k).equals(searchedQueen)) {
                                for (int l = k + 1; l < cards.size(); l++) {
                                    if (cards.get(l).charAt(cards.get(l).length() - 1) == suit && !cards.get(l).equals(searchedKing))
                                        break outerLoop;

                                    if (cards.get(l).equals(searchedKing)){
                                        for (int m = l + 1; m < cards.size(); m++) {
                                            if (cards.get(m).charAt(cards.get(m).length() - 1) == suit && !cards.get(m).equals(searchedAce))
                                                break outerLoop;

                                            if (cards.get(m).equals(searchedAce)) {
                                                count++;

                                                // c, d, h, s
                                                String currentSuit = "";
                                                switch (suit) {
                                                    case 'c':
                                                        currentSuit = "Clubs";
                                                        break;
                                                    case 'd':
                                                        currentSuit = "Diamonds";
                                                        break;
                                                    case 'h':
                                                        currentSuit = "Hearts";
                                                        break;
                                                    case 's':
                                                        currentSuit = "Spades";
                                                        break;
                                                }

                                                cards.remove(m);
                                                cards.remove(l);
                                                cards.remove(k);
                                                cards.remove(j);
                                                cards.remove(i);

                                                System.out.println("Royal Flush Found - " + currentSuit);

                                                i--;
                                                break outerLoop;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Royal's Royal Flushes - " + count + ".");
    }
}
