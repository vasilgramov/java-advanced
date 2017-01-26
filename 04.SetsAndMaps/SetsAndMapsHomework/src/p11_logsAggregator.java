import java.util.*;

public class p11_logsAggregator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeMap<String, Long> durationByUsername = new TreeMap<>();
        HashMap<String, TreeSet<String>> ipsByUsername = new HashMap<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandArgs = in.nextLine().split("\\s+");

            String ip = commandArgs[0];
            String username = commandArgs[1];
            long duratoin = Long.parseLong(commandArgs[2]);

            if (!durationByUsername.containsKey(username) && !ipsByUsername.containsKey(username)) {
                durationByUsername.put(username, 0L);
                ipsByUsername.put(username, new TreeSet<>());
            }

            durationByUsername.put(username, durationByUsername.get(username) + duratoin);

            TreeSet<String> currentSet = ipsByUsername.get(username);
            currentSet.add(ip);
            ipsByUsername.put(username, currentSet);
        }

        for (Map.Entry<String, Long> stringLongEntry : durationByUsername.entrySet()) {
            System.out.print(stringLongEntry.getKey() + ": " + stringLongEntry.getValue() + " [");
            TreeSet<String> currentSet = ipsByUsername.get(stringLongEntry.getKey());
            boolean isFirst = true;
            for (String ip : currentSet) {
                if (isFirst) {
                    System.out.print(ip);
                    isFirst = false;
                } else {
                    System.out.print(", " + ip);
                }
            }

            System.out.println("]");
        }
    }
}
