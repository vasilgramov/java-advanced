import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p08_boundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> boundaries = Arrays.stream(in.readLine().split("\\s+"))
                .map(x -> Integer.parseInt(x))
                .sorted()
                .collect(Collectors.toList());

        Arrays.stream(in.readLine().split("\\s+"))
                .map(x -> Integer.parseInt(x))
                .filter(x -> boundaries.get(0) <= x && x <= boundaries.get(1))
                .forEach(x -> System.out.print(x + " "));

        System.out.println();
    }
}
