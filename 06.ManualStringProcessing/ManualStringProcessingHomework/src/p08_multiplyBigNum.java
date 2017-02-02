import java.math.BigInteger;
import java.util.Scanner;

public class p08_multiplyBigNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String firstNum = in.nextLine();
        String secondNum = in.nextLine();

        BigInteger result = new BigInteger(firstNum).multiply(new BigInteger(secondNum));
        System.out.println(result);
    }
}
