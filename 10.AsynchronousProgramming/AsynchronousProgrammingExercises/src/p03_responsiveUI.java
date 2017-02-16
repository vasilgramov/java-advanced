import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p03_responsiveUI {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = 100000000;
        Runnable taks = () -> {
            primesInRange(n);
        };

        Thread thread = new Thread(taks);
        thread.start();

        while (true) {
            String command = in.nextLine();

            if (command.equals("stop")) {
                thread.interrupt();
                return;
            }
        }
    }

    private static long fib(int n) {
        long n1 = 0;
        long n2 = 1;

        for (int i = 1; i <= n; i++) {
            long temp = n1;
            n1 = n1 + n2;
            n2 = temp;
        }

        return n1;
    }

    private static void primesInRange(int end) {
        List<Integer> primes = new ArrayList<>();

        for (int i = 0; i < end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted...");
                break;
            }
        }

        System.out.println("Primes found: " + primes.size());
    }

    private static boolean isPrime(int number) {
        if (number == 1) return false;
        if (number == 2) return true;

        for (int i = 2; i <= Math.sqrt(number); ++i) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
