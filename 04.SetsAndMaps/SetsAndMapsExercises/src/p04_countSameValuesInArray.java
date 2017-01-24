import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p04_countSameValuesInArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HashMap<String, Integer> countOccurrences = new HashMap<>();
        String[] inputTokens = in.nextLine().split("\\s+");
        for (String token : inputTokens) {
            if (!countOccurrences.containsKey(token)) {
                countOccurrences.put(token, 0);
            }

            countOccurrences.put(token, countOccurrences.get(token) + 1);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : countOccurrences.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue() + " times");
        }
    }
}
