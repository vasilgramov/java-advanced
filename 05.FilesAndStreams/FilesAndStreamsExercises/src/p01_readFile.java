import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class p01_readFile {
    public static void main(String[] args) {
        String path = "/home/vladix/SoftUni/JavaAdvanced/05.FilesAndStreams/FilesAndStreamsExercises/recourses/input.txt";

        try (InputStream in = new FileInputStream(path)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = in.read();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
