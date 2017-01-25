import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p04_countSymbols {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeMap<Character, Integer> countBySymbol = new TreeMap<>();
        char[] input = in.nextLine().toCharArray();

        for (char symbol : input) {
            if (!countBySymbol.containsKey(symbol)) {
                countBySymbol.put(symbol, 1);
            } else {
                countBySymbol.put(symbol, countBySymbol.get(symbol) + 1);
            }
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : countBySymbol.entrySet()) {
            System.out.println(characterIntegerEntry.getKey() + ": " + characterIntegerEntry.getValue() + " time/s");
        }
    }
}
