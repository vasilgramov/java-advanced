import java.util.ArrayDeque;
import java.util.Scanner;

public class p11_simpleTextEditor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int operations = Integer.parseInt(in.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> commands = new ArrayDeque<>();

        for (int i = 0; i < operations; i++) {
            String[] commandArgs = in.nextLine().split("\\s+");
            String commandType = commandArgs[0];

            switch (commandType) {
                case "1":
                    String toBeAdded = commandArgs[1];
                    text.append(toBeAdded);

                    commands.addLast("1" + " " + toBeAdded);
                    break;
                case "2":
                    int count = Integer.parseInt(commandArgs[1]);
                    String toBeRemoved = text.substring(text.length() - count, text.length());
                    text.replace(text.length() - count, text.length(), "");

                    commands.addLast("2" + " " + toBeRemoved);
                    break;
                case "3":
                    int index = Integer.parseInt(commandArgs[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    if (commands.size() == 0) {
                        continue;
                    }

                    String[] lastCommandArgs = commands.removeLast().split(" ");
                    String lastCommandType = lastCommandArgs[0];
                    String argument = lastCommandArgs[1];

                    switch (lastCommandType) {
                        case "1":
                            int length = argument.length();
                            text.replace(text.length() - length, text.length(), "");
                            break;
                        case "2":
                            text.append(argument);
                            break;
                    }
            }
        }
    }
}
