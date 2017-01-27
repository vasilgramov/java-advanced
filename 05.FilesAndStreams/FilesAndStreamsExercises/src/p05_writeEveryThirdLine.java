import java.io.*;

public class p05_writeEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "/home/vladix/input.txt";
        String outputPath = "/home/vladix/output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            PrintWriter writer = new PrintWriter(outputPath);

            int counter = 1;
            String line = reader.readLine();

            while (line != null) {
                if (counter % 3 == 0) {
                    writer.println(line);
                }

                writer.flush();
                counter++;
                line = reader.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
