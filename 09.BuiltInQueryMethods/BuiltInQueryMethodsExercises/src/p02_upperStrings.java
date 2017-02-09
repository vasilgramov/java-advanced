import java.util.Arrays;
import java.util.Scanner;

public class p02_upperStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Arrays.asList(in.nextLine().split("\\s+"))
                .forEach(s -> System.out.print(s.toUpperCase() + " "));
    }
}
