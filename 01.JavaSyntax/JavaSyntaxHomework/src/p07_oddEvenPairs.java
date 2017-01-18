import java.util.Scanner;

public class p07_oddEvenPairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] numsAsString = in.nextLine().split("\\s+");
        if (numsAsString.length % 2 == 1) {
            System.out.println("invalid length");
            return;
        }

        for (int i = 0; i < numsAsString.length; i += 2) {
            int firstNum = Integer.parseInt(numsAsString[i]);
            int secondNum = Integer.parseInt(numsAsString[i + 1]);

            if (firstNum % 2 == 0 && secondNum % 2 == 0)
                System.out.printf("%d, %d -> both are even\n", firstNum, secondNum);
            else if (firstNum % 2 == 1 && secondNum % 2 == 1)
                System.out.printf("%d, %d -> both are odd\n", firstNum, secondNum);
            else
                System.out.printf("%d, %d -> different\n", firstNum, secondNum);
        }
    }
}
