package app.IO;

import app.StaticData.ExceptionMessages;
import app.StaticData.SessionData;

import java.io.File;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by vladix on 4/14/17.
 */
public class IOManager {

    public static void traverseDirectory(int depth) {
        Deque<File> subFolders = new LinkedList<>();

        String path = SessionData.currentPath;

        int initIndentation = path.split("/").length;
        File root = new File(path);

        subFolders.addLast(root);

        while (!subFolders.isEmpty()) {
            File file = subFolders.removeFirst();
            int currentIndentation = file.toString().split("/").length - initIndentation;
            if (depth - currentIndentation < 0) {
                break;
            }

            File[] nestedDir = file.listFiles();
            if (nestedDir != null) {
                for (File nested : nestedDir) {
                    if (nested.isDirectory()) {
                        subFolders.addLast(nested);
                    } else {
                        int lastSlashIndex = nested.toString().lastIndexOf("/");
                        for (int i = 0; i < lastSlashIndex; i++) {
                            OutputWriter.writeMessage("-");
                        }

                        OutputWriter.writeMessageOnNewLine(nested.getName());
                    }
                }
            }

            System.out.println(file.toString());
        }
    }

    public static void createDirectoryInsideFolder(String folderPath) {
        String path = getCurrentDirectoryPath() + "/" + folderPath;
        File file = new File(path);

        file.mkdir();
    }

    public static void changeCurrentDirRelativePath(String relativePath) {
        String path = SessionData.currentPath;

        if (relativePath.equals("..")) {
            int lastSlashIndex = path.lastIndexOf("/");

            SessionData.currentPath = path.substring(0, lastSlashIndex);
        } else {
            path += "/" + relativePath;
            SessionData.currentPath = path;
        }
    }

    public static void changeCurrentDirAbsolutePath(String absolutePath) {
        File file = new File(absolutePath);
        if (!file.exists()) {
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);
            return;
        }

        SessionData.currentPath = absolutePath;
    }

    private static String getCurrentDirectoryPath() {
        String currentDirectoryPath = SessionData.currentPath;
        return currentDirectoryPath;
    }
}
