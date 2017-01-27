import java.io.*;

public class p02_readAFile {
    public static void main(String[] args) {
        String inputPath = "/home/vladix/SoftUni/JavaAdvanced/05.FilesAndStreams/FilesAndStreamsExercises/recourses/Files-and-Streams/input.txt";
        String outputPath = "/home/vladix/SoftUni/JavaAdvanced/05.FilesAndStreams/FilesAndStreamsExercises/recourses/Files-and-Streams/output.txt";

        try (InputStream in = new FileInputStream(inputPath)) {
            OutputStream out = new FileOutputStream(outputPath);

            int oneByte = in.read();
            while (oneByte >= 0) {
                if (',' == oneByte || '.' == oneByte || '!' == oneByte || '?' == oneByte) {
                    oneByte = in.read();
                    continue;
                }

                out.write(oneByte);
                oneByte = in.read();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
