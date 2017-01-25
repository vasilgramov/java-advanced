import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p03_periodicTable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeMap<String, Integer> elementByAppearance = new TreeMap<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] currentLine = in.nextLine().split("\\s+");

            for (int j = 0; j < currentLine.length; j++) {
                if (!elementByAppearance.containsKey(currentLine[j])) {
                    elementByAppearance.put(currentLine[j], 0);
                }

                elementByAppearance.put(currentLine[j], elementByAppearance.get(currentLine[j] + 1));
            }
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : elementByAppearance.entrySet()) {
            System.out.print(stringIntegerEntry.getKey() + " ");
        }
    }
}
