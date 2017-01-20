import java.util.ArrayDeque;
import java.util.Scanner;

public class p05_hotPotato {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] names = in.nextLine().split("\\s+");
        int n = Integer.parseInt(in.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String name : names) {
            queue.add(name);
        }

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++)
                queue.offer(queue.poll());

            System.out.println("Removed " + queue.poll());
        }

        System.out.println("Last is " + queue.poll());
    }
}
