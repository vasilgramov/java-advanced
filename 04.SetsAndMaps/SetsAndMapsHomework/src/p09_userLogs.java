import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p09_userLogs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> countByIPByUsername = new TreeMap<>();

        String command = in.nextLine();
        while (!"end".equals(command)) {
            String[] commandArgs = command.split("=|\\s+");

            String IP = commandArgs[1];
            String username = commandArgs[5];

            if (!countByIPByUsername.containsKey(username)) {
                countByIPByUsername.put(username, new LinkedHashMap<>());
            }

            LinkedHashMap<String, Integer> currentMap = countByIPByUsername.get(username);
            if (!currentMap.containsKey(IP)) {
                currentMap.put(IP, 0);
            }

            currentMap.put(IP, currentMap.get(IP) + 1);

            countByIPByUsername.put(username, currentMap);

            command = in.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> stringTreeMapEntry : countByIPByUsername.entrySet()) {
            String username = stringTreeMapEntry.getKey();
            LinkedHashMap<String, Integer> value = stringTreeMapEntry.getValue();

            System.out.println(username + ":");
            int count = 0;
            for (Map.Entry<String, Integer> stringIntegerEntry : value.entrySet()) {
                if (count == value.size() - 1) {
                    System.out.print(stringIntegerEntry.getKey() + " => " + stringIntegerEntry.getValue() + ".");
                } else {
                    System.out.print(stringIntegerEntry.getKey() + " => " + stringIntegerEntry.getValue() + ", ");
                }

                count++;
            }

            System.out.println( );
        }
    }
}
