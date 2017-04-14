import java.io.File;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by vladix on 4/14/17.
 */
public class Main {

    public static void main(String[] args) {
//        traverseDirectory("/home/vladix/Programmig/JavaAdvanced/00.Bashsoft");


        StudentsRepository.initData();
        StudentsRepository.getStudentByCourse("Unity");
    }

    private static void traverseDirectory(String path) {
        Deque<File> subFolders = new LinkedList<>();
        File root = new File(path);

        subFolders.addLast(root);

        while (!subFolders.isEmpty()) {
            File file = subFolders.removeFirst();

            File[] nestedDir = file.listFiles();
            for (File nested : nestedDir) {
                if (nested.isDirectory()) {
                    subFolders.addLast(nested);
                }
            }

            System.out.println(file.toString());
        }
    }
}
