import java.io.File;

public class p07_listFiles {
    public static void main(String[] args) {
        final String path = "/home/vladix/SoftUni/JavaAdvanced/05.FilesAndStreams/FilesAndStreamsExercises/recourses/Files-and-Streams/Files-and-Streams";
        File file = new File(path);

        if (file.isDirectory()) {
            File[] files = file.listFiles();

            for (File f : files) {
                if (!f.isDirectory()) {
                    System.out.printf("%s: %s\n", f.getName(), f.length());
                }
            }
        }
    }
}
