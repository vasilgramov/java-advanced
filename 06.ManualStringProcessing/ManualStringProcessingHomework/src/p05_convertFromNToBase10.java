import java.math.BigInteger;
import java.util.Scanner;

public class p05_convertFromNToBase10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split("\\s+");
        BigInteger baseN = new BigInteger(input[0]);
        char[] num = input[1].toCharArray();

        BigInteger result = new BigInteger("0");

        int power = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            result = result.add(new BigInteger(Character.toString(num[i])).multiply(baseN.pow(power)));
            power++;
        }

        System.out.println(result);
    }
}
