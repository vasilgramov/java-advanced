import java.util.Scanner;

public class p13_lettersChangeNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] inputArguments = in.nextLine().split("\\s+");
        double totalResult = 0;
        for (int i = 0; i < inputArguments.length; i++) {
            char firstChar = inputArguments[i].charAt(0);
            char lastChar = inputArguments[i].charAt(inputArguments[i].length() - 1);
            double number = Double.parseDouble(inputArguments[i].substring(1, inputArguments[i].length() - 1));

            if (Character.toString(firstChar).equals(Character.toString(firstChar).toLowerCase())) {
                number *= firstChar - 96;
            } else {
                number /= firstChar - 64;
            }

            if (Character.toString(lastChar).equals(Character.toString(lastChar).toLowerCase())) {
                number += lastChar - 96;
            } else {
                number -= lastChar - 64;
            }

            totalResult += number;
        }

        System.out.printf("%.2f\n", totalResult);
    }
}