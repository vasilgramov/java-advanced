import java.io.*;

public class p03_copyBytes {
    public static void main(String[] args) {
        String inputPath = "/home/vladix/SoftUni/JavaAdvanced/05.FilesAndStreams/FilesAndStreamsExercises/recourses/Files-and-Streams/input.txt";
        String outputPath = "/home/vladix/SoftUni/JavaAdvanced/05.FilesAndStreams/FilesAndStreamsExercises/recourses/Files-and-Streams/Files-and-Streams/output.txt";

        try (InputStream in = new FileInputStream(inputPath)) {
            OutputStream out = new FileOutputStream(outputPath);

            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++)
                        out.write(digits.charAt(i));
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
