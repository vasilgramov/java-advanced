import java.util.Scanner;

public class p03_decimalToBinary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        System.out.println(Integer.toBinaryString(n));
    }
}
