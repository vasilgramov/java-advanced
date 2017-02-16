import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class p02_arraySlider {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] numsAsString = in.readLine().trim().split("\\s+");
        BigInteger[] numbers  = new BigInteger[numsAsString.length];

        int index = 0;
        for (String str : numsAsString) {
            numbers[index++] = new BigInteger(str);
        }


        //  '&' (bitwise AND), '|' (bitwise OR), '^' (bitwise XOR), '+' (add), '-' (subtract), '*' (multiply), '/' (divide)
        index = 0;
        String command = in.readLine();
        while (!"stop".equals(command)) {
            String[] commandArgs = command.trim().split("\\s+");

            int offset = Integer.parseInt(commandArgs[0]) % numbers.length;
            String operation = commandArgs[1];
            BigInteger operand = new BigInteger(commandArgs[2]);

            index += offset;
            index %= numbers.length;
            if (index < 0)
                index = numbers.length + index;

            switch (operation) {
                case "&":
                    numbers[index] = numbers[index].and(operand);
                    break;
                case "|":
                    numbers[index] = numbers[index].or(operand);
                    break;
                case "^":
                    numbers[index] = numbers[index].xor(operand);
                    break;
                case "+":
                    numbers[index] = numbers[index].add(operand);
                    break;
                case "-":
                    numbers[index] = numbers[index].subtract(operand);
                    break;
                case "*":
                    numbers[index] = numbers[index].multiply(operand);
                    break;
                case "/":
                    numbers[index] = numbers[index].divide(operand);
                    break;
            }

             command = in.readLine();
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].compareTo(new BigInteger("0")) < 0)
                numbers[i] = new BigInteger("0");
        }

        System.out.println(Arrays.toString(numbers));
    }
}
