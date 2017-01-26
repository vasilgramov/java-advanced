import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class p13_srubskoUnleashed {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedHashMap<String, HashMap<String, Long>> priceBySingerByVenue = new LinkedHashMap<>();

        Pattern regexPattern = Pattern.compile("([a-zA-Z]+\\s){1,3}@([a-zA-Z]+\\s){1,3}\\d+\\s\\d+");

        String command = in.nextLine();
        while (!"End".equals(command)) {
            if (!regexPattern.matcher(command).matches()) {
                command = in.nextLine();
                continue;
            }


            String[] commandArgs = command.split(" ");
            String singer = command.substring(0, command.indexOf('@')).trim();
            long ticketPrice = Long.parseLong(commandArgs[commandArgs.length - 2]);
            long ticketCount = Long.parseLong(commandArgs[commandArgs.length - 1]);
            String venue = command.substring(command.indexOf('@') + 1, command.indexOf(Long.toString(ticketPrice))).trim();

            if (!priceBySingerByVenue.containsKey(venue)) {
                priceBySingerByVenue.put(venue, new LinkedHashMap<>());
            }

            long currentPrice = ticketPrice * ticketCount;

            HashMap<String, Long> currentLinkedMap = priceBySingerByVenue.get(venue);
            if (!currentLinkedMap.containsKey(singer)) {
                currentLinkedMap.put(singer, 0L);
            }

            currentLinkedMap.put(singer, currentLinkedMap.get(singer) + currentPrice);
            priceBySingerByVenue.put(venue, currentLinkedMap);

            command = in.nextLine();
        }



        for (Map.Entry<String, HashMap<String, Long>> stringHashMapEntry : priceBySingerByVenue.entrySet()) {
            String venue = stringHashMapEntry.getKey();

            System.out.println(venue);
            HashMap<String, Long> currentHashMap = stringHashMapEntry.getValue();

            LinkedHashMap<String, Long> sorted = new LinkedHashMap<>();
            currentHashMap.entrySet().stream()
                    .sorted((c1, c2) -> currentHashMap.get(c2.getKey()).compareTo(currentHashMap.get(c1.getKey())))
                    .forEach(x -> sorted.put(x.getKey(), x.getValue()));

            for (Map.Entry<String, Long> stringLongEntry : sorted.entrySet()) {
                System.out.println("#  " + stringLongEntry.getKey() + " -> " + stringLongEntry.getValue());
            }
        }
    }
}
