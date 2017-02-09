import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p14_triFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        String[] names = in.readLine().split("\\s+");
        for (String name : names) {
            int sumOfChars = 0;
            for (int i = 0; i < name.length(); i++) {
                sumOfChars += name.charAt(i);
            }

            if (sumOfChars >= n) {
                System.out.println(name);
                return;
            }
        }
    }
}
