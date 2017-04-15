package app.IO;

import app.CommandInterpreter;
import app.StaticData.SessionData;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by vladix on 4/15/17.
 */
public class InputReader {

    private static String END_COMMAND = "quit";

    public static void readCommands() throws IOException {
        Scanner in = new Scanner(System.in);

        OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));
        String input = in.nextLine().trim();
        while (!input.equals(END_COMMAND)) {
            CommandInterpreter.interpretCommand(input);
            OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));

            input = in.nextLine();
        }

    }

}
