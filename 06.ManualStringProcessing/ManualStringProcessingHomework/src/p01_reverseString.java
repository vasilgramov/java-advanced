import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_reverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input = in.readLine();
        System.out.println(new StringBuilder(input).reverse());
    }
}
