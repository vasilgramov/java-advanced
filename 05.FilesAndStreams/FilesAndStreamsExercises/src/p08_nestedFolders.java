import java.io.File;
import java.util.ArrayDeque;

public class p08_nestedFolders {
    public static void main(String[] args) {
        final String path = "/home/vladix/Downloads";

        File file = new File(path);
        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.addLast(file);

        int counter = 0;
        while (!queue.isEmpty()) {
            File currentDir = queue.removeFirst();

            File[] nestedFolders = currentDir.listFiles();
            for (File folder : nestedFolders) {
                if (folder.isDirectory()) {
                    queue.addLast(folder);
                }
            }

            System.out.println(currentDir);
            counter++;
        }

        System.out.println(counter + " Folders");
    }
}
