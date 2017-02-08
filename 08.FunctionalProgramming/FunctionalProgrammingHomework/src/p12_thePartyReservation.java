import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class p12_thePartyReservation {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] names = in.readLine().split("\\s+");

        HashMap<String, HashSet<String>> filters = new HashMap<>();
        filters.put("Starts with", new HashSet<>());
        filters.put("Ends with", new HashSet<>());
        filters.put("Length with", new HashSet<>());
        filters.put("Contains", new HashSet<>());

        String command = in.readLine();
        while (!"Print".equals(command)) {
            String[] commandArgs = command.split(";");
            String commandType = commandArgs[0];
            String filterType = commandArgs[1];
            String parameter = commandArgs[2];

            if (commandType.equals("Add filter")) {
                HashSet<String> currentFilters = filters.get(filterType);
                currentFilters.add(parameter);
            } else {
                HashSet<String> currentFilters = filters.get(filterType);
                if (currentFilters.contains(parameter))
                    currentFilters.remove(parameter);
            }


            command = in.readLine();
        }


        for (String name : names) {
            boolean isValid = true;

            outerLoop:
            for (Map.Entry<String, HashSet<String>> stringHashSetEntry : filters.entrySet()) {
                String filter = stringHashSetEntry.getKey();
                HashSet<String> parameters = stringHashSetEntry.getValue();

                for (String parameter : parameters) {
                    switch (filter) {
                        case "Starts with":
                            if (name.startsWith(parameter)) {
                                isValid = false;
                                break outerLoop;
                            }
                            break;
                        case "Ends with":
                            if (name.endsWith(parameter)) {
                                isValid = false;
                                break outerLoop;
                            }
                            break;
                        case "Length with" :
                            int length = Integer.parseInt(parameter);
                            if (name.length() == length) {
                                isValid = false;
                                break outerLoop;
                            }
                            break;
                        case "Contains":
                            if (name.contains(parameter)) {
                                isValid = false;
                                break outerLoop;
                            }
                            break;
                    }
                }
            }

            if (isValid)
                System.out.print(name + " ");
        }
    }
}
