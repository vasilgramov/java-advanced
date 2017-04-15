package app;

import app.IO.IOManager;
import app.Judge.Tester;
import app.Repository.StudentsRepository;
import app.StaticData.SessionData;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by vladix on 4/15/17.
 */
public class CommandInterpreter {

    private static final String HELP_PATH_FILE = "/home/vladix/Programmig/JavaAdvanced/00.Bashsoft/00.get_help.txt";

    public static void interpretCommand(String line) throws IOException {
        String[] tokens = line.split("\\s+");
        String command = tokens[0];

        switch (command) {
            case "mkdir":
                tryCreatingDir(line, tokens);
                break;
            case "ls":
                tryTraverseFolders(line, tokens);
                break;
            case "cmp":
                tryCompareFiles(line, tokens);
                break;
            case "changeDirRel":
                tryChangeDirRel(line, tokens);
                break;
            case "changeDirAbs":
                tryChangeDirAbs(line, tokens);
                break;
            case "readDb":
                tryReadDBFromFile(line, tokens);
                break;
            case "filter":
                tryPrintFilteredStudentsRepository(line, tokens);
                break;
            case "order":
                tryPrintOrderedStudentsRepository(line, tokens);
                break;
            case "download":
                break;
            case "downloadAsynch":
                break;
            case "help":
                tryGetHelp(line, tokens);
                break;
            case "open":
                tryOpenFile(line, tokens);
                break;
            case "show":
                tryShowWantedCourses(line, tokens);
                break;
            default:
                displayInvalidCommandMessage(line);
                break;
        }

    }

    private static void tryPrintOrderedStudentsRepository(String line, String[] tokens) {
        if (tokens.length != 4) {
            return;
        }

        String course = tokens[1];
        String filter = tokens[2];
        int numberOfStudents = Integer.parseInt(tokens[3]);

        StudentsRepository.printOrderedStudents(course, filter, numberOfStudents);
    }

    private static void tryPrintFilteredStudentsRepository(String line, String[] tokens) {
        if (tokens.length != 4) {
            return;
        }

        String course = tokens[1];
        String filter = tokens[2];
        int numberOfStudents = Integer.parseInt(tokens[3]);

        StudentsRepository.printFilteredStudents(course, filter, numberOfStudents);
    }

    private static void tryShowWantedCourses(String line, String[] tokens) {
        if (tokens.length != 2 && tokens.length != 3) {
            displayInvalidCommandMessage(line);
            return;
        }

        if (tokens.length == 2) {
            String courseName = tokens[1];
            StudentsRepository.getStudentByCourse(courseName);
        }

        if (tokens.length == 3) {
            String courseName = tokens[1];
            String userName = tokens[2];

            StudentsRepository.getStudentMarksInCourse(courseName, userName);
        }
    }

    private static void tryGetHelp(String line, String[] tokens) throws IOException {
        if (tokens.length != 1) {
            displayInvalidCommandMessage(line);
            return;
        }

        File help = new File(HELP_PATH_FILE);
        List<String> commands = Files.readAllLines(Paths.get(HELP_PATH_FILE));
        for (String command : commands) {
            System.out.println(command);
        }
    }

    private static void tryReadDBFromFile(String line, String[] tokens) throws IOException {
        if (tokens.length != 2) {
            displayInvalidCommandMessage(line);
            return;
        }

        String fileName = tokens[1];
        StudentsRepository.initData(fileName);
    }

    private static void tryChangeDirAbs(String line, String[] tokens) {
        if (tokens.length != 2) {
            displayInvalidCommandMessage(line);
            return;
        }


        String absPath = tokens[1];
        IOManager.changeCurrentDirAbsolutePath(absPath);
    }

    private static void tryChangeDirRel(String line, String[] tokens) {
        if (tokens.length != 2) {
            displayInvalidCommandMessage(line);
            return;
        }

        String relPath = tokens[1];
        IOManager.changeCurrentDirRelativePath(relPath);
    }

    private static void tryCompareFiles(String line, String[] tokens) throws IOException {
        if (tokens.length != 3) {
            displayInvalidCommandMessage(line);
            return;
        }

        String firstPath = tokens[1];
        String secondPath = tokens[2];

        Tester.compareContent(firstPath, secondPath);
    }

    private static void tryTraverseFolders(String line, String[] tokens) {
        if (tokens.length != 1 && tokens.length != 2) {
            displayInvalidCommandMessage(line);
            return;
        }

        if (tokens.length == 1) {
            IOManager.traverseDirectory(0);
        } else {
            IOManager.traverseDirectory(Integer.parseInt(tokens[1]));
        }
    }

    private static void tryCreatingDir(String line, String[] tokens) {
        if (tokens.length != 2) {
            displayInvalidCommandMessage(line);
            return;
        }

        String folderName = tokens[1];
        IOManager.createDirectoryInsideFolder(folderName);
    }

    private static void tryOpenFile(String line, String[] tokens) throws IOException {
        if (tokens.length != 2) {
            displayInvalidCommandMessage(line);
            return;
        }

        String fileName = tokens[1];
        String filePath = SessionData.currentPath + "/" + fileName;
        File file = new File(filePath);
        Desktop.getDesktop().open(file);
    }

    private static void displayInvalidCommandMessage(String line) {
        System.out.println(String.format("The command %s is invalid", line));
    }

}
