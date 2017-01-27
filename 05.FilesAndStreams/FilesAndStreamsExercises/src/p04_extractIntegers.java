import java.io.*;
import java.util.Scanner;

public class p04_extractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "/home/vladix/input.txt";
        String outputPath = "/home/vladix/output.txt";

        try (Scanner in = new Scanner(new FileInputStream(inputPath));
            PrintWriter writer = new PrintWriter(outputPath)) {
            while (in.hasNext()) {
                if (in.hasNextInt()) {
                    writer.println(in.nextInt());
                }

                in.next();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

