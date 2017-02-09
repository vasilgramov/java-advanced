import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p01_takeTwo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] tokens = in.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < tokens.length; i++) {
            numbers.add(Integer.parseInt(tokens[i]));
        }

        numbers.stream()
                .filter(x -> 10 <= x && x <= 20)
                .limit(2)
                .distinct()
                .forEach(x -> System.out.print(x + " "));
    }
}
