import java.util.LinkedHashSet;
import java.util.Scanner;

public class p01_uniqueUsernames {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedHashSet<String> names = new LinkedHashSet<>();
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            names.add(name);
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
