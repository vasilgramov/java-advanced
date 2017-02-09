import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;

public class p03_firstName {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] tokens = in.nextLine().split("\\s+");
        String[] charsInput = in.nextLine().split("\\s+");
        HashSet<Character> chars = new HashSet<>();
        for (String str : charsInput) {
            chars.add(Character.toLowerCase(str.charAt(0)));
        }

        Optional<String> name = Arrays.stream(tokens)
                .sorted()
                .filter(x -> chars.contains(Character.toLowerCase(x.charAt(0))))
                .findFirst();

        if (name.isPresent())
            System.out.println(name.get());
        else
            System.out.println();
    }
}
