import java.util.Scanner;

public class p03_formattingNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split("\\s+");
        int a = Integer.parseInt(input[0]);
        double b = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);

        String hexA = Integer.toHexString(a).toUpperCase();
        hexA = String.format("|%1$-10s|", hexA);
        StringBuilder binA = new StringBuilder(Integer.toBinaryString(a));
        while (binA.length() > 10) {
            binA = binA.deleteCharAt(binA.length() - 1);
        }
        while (binA.length() < 10) {
            binA = binA.insert(0, "0");
        }

        String formattedB = String.format("%1$10.2f", b);
        String formattedC = String.format("%1$-10.3f", c);
        hexA += binA + "|" + formattedB + "|" + formattedC + "|";

        System.out.println(hexA);
    }
}
