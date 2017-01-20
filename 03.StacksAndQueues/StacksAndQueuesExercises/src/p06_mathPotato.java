import java.util.ArrayDeque;
import java.util.Scanner;

public class p06_mathPotato {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] names = in.nextLine().split("\\s+");
        int n = Integer.parseInt(in.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String name : names) {
            queue.add(name);
        }

        int count = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++)
                queue.offer(queue.poll());

            if (!isPrime(count))
                System.out.println("Removed " + queue.poll());
            else
                System.out.println("Prime " + queue.peek());

            count++;
        }

        System.out.println("Last is " + queue.poll());
    }

    public static boolean isPrime(int number)
    {
        if (number == 1) return false;
        if (number == 2) return true;

        int boundary = (int)Math.floor(Math.sqrt(number));

        for (int i = 2; i <= boundary; ++i)
        {
            if (number % i == 0)  return false;
        }

        return true;
    }
}
