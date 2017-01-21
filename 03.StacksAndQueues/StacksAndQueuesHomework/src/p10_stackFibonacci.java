import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Scanner;

public class p10_stackFibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayDeque<BigInteger> stack = new ArrayDeque<>();
        stack.addLast(BigInteger.ONE);
        stack.addLast(BigInteger.ONE);

        int n = Integer.parseInt(in.nextLine());

        if (n == 0) {
            System.out.println(1);
            return;
        }

        if (n == 1 || n == 2) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i < n; i++) {
            BigInteger toPeek = stack.removeLast();
            BigInteger toPush = stack.removeLast();

            stack.addLast(toPeek);
            stack.addLast(toPeek.add(toPush));
        }

        System.out.println(stack.peek());
    }
}
