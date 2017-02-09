import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class p13_inferno {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] numbersAsString = in.readLine().split("\\s+");
        int[] numbers = new int[numbersAsString.length];

        for (int i = 0; i < numbersAsString.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }

        HashMap<String, ArrayList<Integer>> markedForExclusion = new HashMap<>();

        String command = in.readLine();
        while (!"Forge".equals(command)) {
            String[] commandArgs = command.split(";");
            String commandType = commandArgs[0];
            String filter = commandArgs[1];
            int parameter = Integer.parseInt(commandArgs[2]);

            String wholeCommand = filter + " " + parameter;

            if (commandType.equals("Exclude")) {
                // mark for exclusion
                String[] splittedFilters = filter.split("\\s+");

                ArrayList<Integer> excludedNums = new ArrayList<>();
                if (splittedFilters.length == 2 && splittedFilters[1].equals("Left")) {
                    // sum left
                    if (numbers[0] == parameter) {
                        excludedNums.add(numbers[0]);
                    }

                    for (int i = 1; i < numbers.length; i++) {
                        int sum = numbers[i] + numbers[i - 1];

                        if (sum == parameter) {
                            excludedNums.add(numbers[i]);
                        }
                    }
                } else if (splittedFilters.length == 2 && splittedFilters[1].equals("Right")) {
                    // sum right
                    if (numbers[numbers.length - 1] == parameter) {
                        excludedNums.add(numbers[numbers.length - 1]);
                    }

                    for (int i = numbers.length - 2; i >= 0; i--) {
                        int sum = numbers[i] + numbers[i + 1];

                        if (sum == parameter) {
                            excludedNums.add(numbers[i]);
                        }
                    }

                } else {
                    // sum left right
                    if (numbers.length == 1 && numbers[0] == parameter) {
                        excludedNums.add(numbers[0]);
                    } else if (numbers.length > 1) {
                        if (numbers[0] + numbers[1] == parameter) {
                            excludedNums.add(numbers[0]);
                        }

                        if (numbers[numbers.length - 1] + numbers[numbers.length - 2] == parameter) {
                            excludedNums.add(numbers[numbers.length - 1]);
                        }

                        int sum = 0;
                        for (int i = 1; i < numbers.length - 1; i++) {
                            int left = numbers[i - 1];
                            int right = numbers[i + 1];

                            if (left + numbers[i] + right == parameter) {
                                excludedNums.add(numbers[i]);
                            }
                        }
                    }
                }

                if (excludedNums.size() > 0)
                    markedForExclusion.put(wholeCommand, excludedNums);
            } else {
                // unmarked for exclusion
                HashMap<String, ArrayList<Integer>> newMarkedForExclusion = new HashMap<>();

                for (Map.Entry<String, ArrayList<Integer>> stringArrayListEntry : markedForExclusion.entrySet()) {
                    String currentWholeCommand = stringArrayListEntry.getKey();
                    ArrayList<Integer> currentMarkedNumbers = stringArrayListEntry.getValue();

                    if (!currentWholeCommand.equals(wholeCommand)) {
                        newMarkedForExclusion.put(currentWholeCommand, currentMarkedNumbers);
                    }
                }

                markedForExclusion = newMarkedForExclusion;
            }

            command = in.readLine();
        }

        ArrayList<Integer> allExcludedNumbers = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Integer>> stringArrayListEntry : markedForExclusion.entrySet()) {
            ArrayList<Integer> currentMarkedNumbers = stringArrayListEntry.getValue();

            allExcludedNumbers.addAll(currentMarkedNumbers);
        }

        for (int number : numbers) {
            if (!allExcludedNumbers.contains(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
