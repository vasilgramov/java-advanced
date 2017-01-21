import java.util.ArrayDeque;
import java.util.Scanner;

public class p05_calculateSequenceWithQueue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayDeque<Long> sequence = new ArrayDeque<>();
        long startIndex = in.nextLong();
        sequence.addLast(startIndex);
        int count = 0;
        while (count < 50) {
            long toPrint = sequence.removeFirst();

            System.out.print(toPrint + " ");

            sequence.addLast(toPrint + 1);
            sequence.addLast(2 * toPrint + 1);
            sequence.addLast(toPrint + 2);

            count++;
        }
    }
}
