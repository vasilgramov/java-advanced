import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Function;

public class p01_consumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Consumer<String[]> print = str -> {
            for (String currentStr : str) {
                System.out.println(currentStr);
            }
        };

        String[] input = in.readLine().split("\\s+");
        print.accept(input);
    }
}
