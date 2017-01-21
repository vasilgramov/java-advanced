import java.util.ArrayDeque;
import java.util.Scanner;

public class p04_basicQueueOperation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] commandArgs = in.nextLine().split("\\s+");
        int toEnqueue = Integer.parseInt(commandArgs[0]);
        int toDequeue = Integer.parseInt(commandArgs[1]);
        int searched = Integer.parseInt(commandArgs[2]);

        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < toEnqueue; i++) {
            String elementToAdd = in.next();


            if (count >= toDequeue) {
                if (Integer.parseInt(elementToAdd) < min) {
                    min = Integer.parseInt(elementToAdd);
                }

                if (Integer.parseInt(elementToAdd) == searched) {
                    System.out.println("true");
                    return;
                }
            }

            queue.addLast(elementToAdd);
            count++;
        }

        if (min == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(min);
    }
}
