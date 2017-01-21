import java.util.Scanner;

public class p09_recursiveFibonacci {         // iterative fibonacci
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        getNthFibonacci(n);
    }

    private static void getNthFibonacci(int n) {
        if (n == 1 || n == 2) {
            System.out.println(1);
            return;
        }

        long fib1 = 1;
        long fib2 = 1;
        long fib3 = 2;

        for (int i = 3; i < n; i++) {
            fib1 = fib2;
            fib2 = fib3;
            fib3 = fib1 + fib2;
        }

        System.out.println(fib3);
    }
}
