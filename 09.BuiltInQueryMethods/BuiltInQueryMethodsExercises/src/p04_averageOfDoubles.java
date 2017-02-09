import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class p04_averageOfDoubles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        DoubleStream nums = Arrays.stream(in.nextLine().split("\\s+"))
                .distinct()
                .filter(x -> !x.isEmpty())
                .map(x -> Double.parseDouble(x))
                .mapToDouble(x -> x);

        OptionalDouble averageSum = nums.average();

        if (averageSum.isPresent())
            System.out.printf("%.2f", averageSum.getAsDouble());
        else
            System.out.println("No match");
    }
}
