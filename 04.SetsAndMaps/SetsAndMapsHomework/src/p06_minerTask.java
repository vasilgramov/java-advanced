import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p06_minerTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedHashMap<String, Integer> quantityByResource = new LinkedHashMap<>();
        String command = in.nextLine();
        while (!"stop".equals(command)) {
            int quantity = Integer.parseInt(in.nextLine());

            if (!quantityByResource.containsKey(command)) {
                quantityByResource.put(command, quantity);
            } else {
                quantityByResource.put(command, quantityByResource.get(command) + quantity);
            }

            command = in.nextLine();
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : quantityByResource.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + " -> " + stringIntegerEntry.getValue());
        }
    }
}
