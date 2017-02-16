import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class p04_benchmark {

    public static void main(String[] args) {
        int n = 1000000;

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(i);
        }

        long start = System.nanoTime();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future[] results = new Future[numbers.size()];

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            Future<Boolean> future = executorService.submit(() -> isPrime(number));
            results[i] = future;
        }

        long total = System.nanoTime() - start;
        System.out.println("Execution time: " + total);

        executorService.shutdown();
    }

    private static boolean isPrime(int number) {
        if (number == 1) return false;
        if (number == 2) return true;

        for (int i = 2; i <= Math.ceil(Math.sqrt(number)); ++i) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
