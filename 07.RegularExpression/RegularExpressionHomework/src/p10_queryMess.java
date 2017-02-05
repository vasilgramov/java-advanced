import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class p10_queryMess {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input = in.readLine();
        while (!"END".equals(input)) {
            int startIndex = input.contains("?") ? input.indexOf("?") : -1;
            if (startIndex != -1) {
                input = input.substring(startIndex + 1);
            }

            LinkedHashMap<String, ArrayList<String>> valuesByKey = new LinkedHashMap<>();
            String[] separated = input.split("&");
            for (String current : separated) {
                current = current.replaceAll("(%20|\\+)+", " ");
                String[] parts = current.split("=");
                String key = parts[0].trim();
                String value = parts[1].trim();

                if (!valuesByKey.containsKey(key)) {
                    valuesByKey.put(key, new ArrayList<>());
                }

                ArrayList<String> arrayList = valuesByKey.get(key);
                arrayList.add(value);
                valuesByKey.put(key, arrayList);
            }

            for (Map.Entry<String, ArrayList<String>> stringArrayListEntry : valuesByKey.entrySet()) {
                String key = stringArrayListEntry.getKey();
                System.out.print(key + "=[");
                boolean isFirst = true;
                ArrayList<String> values = stringArrayListEntry.getValue();
                for (String value : values) {
                    String copyValue = new String(value);
                    copyValue = copyValue.replace("\\s+", " ").trim();
                    if (isFirst) {
                        System.out.print(copyValue);
                        isFirst = false;
                    } else {
                        System.out.print(", " + copyValue);
                    }
                }

                System.out.print("]");
            }

            System.out.println();
            input = in.readLine();
        }
    }
}
