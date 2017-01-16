import java.util.Scanner;

public class p01_readInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String firstWord = in.next();
        String secondWord = in.next();
        int fistInt = in.nextInt();
        int secondInt = in.nextInt();
        int thirdInt = in.nextInt();
        String thirdWord = in.next();

        System.out.printf("%s %s %s %d", firstWord, secondWord, thirdWord, fistInt + secondInt + thirdInt);
    }
}
