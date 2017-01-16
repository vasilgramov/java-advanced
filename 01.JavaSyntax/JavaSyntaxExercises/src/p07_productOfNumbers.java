import java.math.BigInteger;
import java.util.Scanner;

public class p07_productOfNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int startNum = in.nextInt();
        int endNum = in.nextInt();

        BigInteger product = new BigInteger("1");
        for (int i = startNum; i <= endNum; i++) {
            product = product.multiply(new BigInteger(Integer.toString(i)));
        }

        System.out.printf("product[%d..%d] = %d", startNum, endNum, product);
    }
}
