import java.util.LinkedHashSet;
import java.util.Scanner;

public class p02_setsOfElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            firstSet.add(in.nextInt());
        }

        for (int i = 0; i < m; i++) {
            secondSet.add(in.nextInt());
        }


        firstSet.retainAll(secondSet);
        for (Integer integer : firstSet) {
            System.out.print(integer + " ");
        }
    }
}
