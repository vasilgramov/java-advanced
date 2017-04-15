package app.IO;

import java.util.List;

/**
 * Created by vladix on 4/14/17.
 */
public class OutputWriter {

    public static void writeMessage(String message) {
        System.out.print(message);
    }

    public static void writeMessageOnNewLine(String message) {
        System.out.println(message);
    }

    public static void writeEmptyLine() {
        System.out.println();
    }

    public static void displayException(String message) {
        System.out.print(message);
    }

    public static void printStudent(String name, List<Integer> makrs) {
        String output = String.format("%s - %s", name, makrs.toString());

        OutputWriter.writeMessageOnNewLine(output);
    }

}
