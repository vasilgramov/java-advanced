import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p04_specialWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] specialWords = in.nextLine().split(" ");
        HashMap<String, Integer> countBySpecialWord = new HashMap<>();
        for (String specialWord : specialWords) {
            countBySpecialWord.put(specialWord, 0);
        }

        String[] text = in.nextLine().split(" ");
        for (String word : text) {
            if (countBySpecialWord.containsKey(word)) {
                countBySpecialWord.put(word, countBySpecialWord.get(word) + 1);
            }
        }

//        String a = new String("asd");
//        a.hashCode();

        for (Map.Entry<String, Integer> stringIntegerEntry : countBySpecialWord.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue());
        }
    }
}
