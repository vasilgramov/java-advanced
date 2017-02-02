import java.util.HashSet;
import java.util.Scanner;

public class p14_magicExchangeableWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split("\\s+");
        String first = input[0];
        String second = input[1];

        HashSet<Character> firstSet = new HashSet<>();
        HashSet<Character> secondSet = new HashSet<>();

        for (int i = 0; i < first.length(); i++) {
            firstSet.add(first.charAt(i));
        }

        for (int i = 0; i < second.length(); i++) {
            secondSet.add(second.charAt(i));
        }

        System.out.println(firstSet.size() == secondSet.size() ? "true" : "false" );
    }
}
