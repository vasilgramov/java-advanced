import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p05_filterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        LinkedHashMap<String, Integer> ageByName = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] currentLine = in.readLine().split(", ");
            ageByName.put(currentLine[0], Integer.parseInt(currentLine[1]));
        }

        String condition = in.readLine();
        int conditionAge = Integer.parseInt(in.readLine());
        String[] toPrint = in.readLine().split(" ");

        LinkedHashMap<String, Integer> filteredNames = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : ageByName.entrySet()) {
            String name = stringIntegerEntry.getKey();
            int currentAge = stringIntegerEntry.getValue();

            if (isInCondition(currentAge, condition, conditionAge))
                filteredNames.put(name, currentAge);
        }

        boolean onlyName = false;
        boolean onlyAge = false;
        for (String str : toPrint) {
            if (str.toLowerCase().equals("name"))
                onlyName = true;
            else
                onlyAge = true;
        }

        boolean bothNameAndAge = onlyName == true && onlyAge == true ? true : false;

        for (Map.Entry<String, Integer> stringIntegerEntry : filteredNames.entrySet()) {
            if (bothNameAndAge)
                System.out.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue());
            else if (onlyName)
                System.out.println(stringIntegerEntry.getKey());
            else
                System.out.println(stringIntegerEntry.getValue());
        }
    }

    private static boolean isInCondition(int currentAge, String condition, int conditionAge) {
        if (condition.equals("younger")) {
            if (currentAge <= conditionAge)
                return true;

            return false;
        } else {
            if (currentAge >= conditionAge)
                return true;

            return false;
        }
    }
}
