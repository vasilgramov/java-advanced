import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.UnaryOperator;

public class p04_addVAT {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        UnaryOperator<Double> withVAT = num -> num + num * 20.0 / 100.0;
        String[] input = in.readLine().split(",\\s+");

        System.out.println("Prices with VAT:");
        for (String str : input) {
            double currentNum = Double.parseDouble(str);
            System.out.println(String.format("%.2f", withVAT.apply(currentNum)).replace('.', ','));
        }
    }
}
