import java.util.ArrayDeque;
import java.util.Scanner;

public class p02_basicStackOperations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] commandArgs = in.nextLine().split("\\s+");
        int toPush = Integer.parseInt(commandArgs[0]);
        int toPop = Integer.parseInt(commandArgs[1]);
        String searched = commandArgs[2];

        String[] numbersAsString = in.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < toPush; i++) {
            stack.addFirst(numbersAsString[i]);
        }

        for (int i = 0; i < toPop; i++) {
            stack.removeFirst();
        }

        int min = Integer.MAX_VALUE;
        for (String s : stack) {
            int current = Integer.parseInt(s);
            if (current < min)
                min = current;

            if (s.equals(searched)) {
                System.out.println("true");
                return;
            }
        }

        if (stack.size() == 0) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
