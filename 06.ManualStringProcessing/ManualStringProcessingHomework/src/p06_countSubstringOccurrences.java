import java.util.Scanner;

public class p06_countSubstringOccurrences {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String copy = in.nextLine().toLowerCase();
        String pattern = in.nextLine().toLowerCase();

        int count = 0;
        while (true) {
            if (copy.contains(pattern))
                count++;
            else
                break;

            copy = copy.substring(copy.indexOf(pattern) + 1);
        }

        System.out.println(count);
    }
}
