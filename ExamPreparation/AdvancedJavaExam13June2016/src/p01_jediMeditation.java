import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p01_jediMeditation {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<String> masters = new ArrayDeque<>();
        ArrayDeque<String> knights = new ArrayDeque<>();
        ArrayDeque<String> padawan = new ArrayDeque<>();
        ArrayDeque<String> toshkoAndSlav = new ArrayDeque<>();

        boolean yodaHasShown = false;

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                if (input[j].charAt(0) == 'm') {
                    masters.addLast(input[j]);
                } else if (input[j].charAt(0) == 'k') {
                    knights.addLast(input[j]);
                } else if (input[j].charAt(0) == 'p') {
                    padawan.addLast(input[j]);
                } else if (input[j].charAt(0) == 'y') {
                    yodaHasShown = true;
                } else if (input[j].charAt(0) == 't' || input[j].charAt(0) == 's') {
                    toshkoAndSlav.addLast(input[j]);
                }
            }
        }

        StringBuilder builer = new StringBuilder();
        if (yodaHasShown) {
            for (String master : masters) {
                builer.append(master + " ");
            }
            for (String knight : knights) {
                builer.append(knight + " ");
            }
            for (String s : toshkoAndSlav) {
                builer.append(s + " ");
            }
            for (String s : padawan) {
                builer.append(s + " ");
            }
        } else {
            for (String s : toshkoAndSlav) {
                builer.append(s + " ");
            }
            for (String master : masters) {
                builer.append(master + " ");
            }
            for (String knight : knights) {
                builer.append(knight + " ");
            }
            for (String s : padawan) {
                builer.append(s + " ");
            }
        }

        System.out.println(builer);
    }
}
