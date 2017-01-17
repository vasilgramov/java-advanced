import java.util.Arrays;
import java.util.Scanner;

public class p01_readSortPrintArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int length = Integer.parseInt(in.nextLine());
        String[] names = new String[length];

        for (int i = 0; i < length; i++) {
            names[i] = in.nextLine();
        }

        Arrays.sort(names);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
