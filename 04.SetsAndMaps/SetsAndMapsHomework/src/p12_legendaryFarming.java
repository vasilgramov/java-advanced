import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p12_legendaryFarming {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeMap<String, Long> junkItems = new TreeMap<>();

        TreeMap<String, Long> keyItems = new TreeMap<>();
        keyItems.put("shards", 0L);
        keyItems.put("fragments", 0L);
        keyItems.put("motes", 0L);

        boolean shadowmourne = false;
        boolean valanyr = false;
        boolean dragonwrath = false;

        while (true) {
            String[] commandArgs = in.nextLine().split("\\s+");
            boolean hasBroken = false;
            for (int i = 0; i < commandArgs.length; i += 2) {
                String material = commandArgs[i + 1].toLowerCase();
                long quantity = Long.parseLong(commandArgs[i]);

                if (isKeyItem(material)) {
                    keyItems.put(material, keyItems.get(material) + quantity);
                } else {
                    if (!junkItems.containsKey(material)) {
                        junkItems.put(material, 0L);
                    }

                    junkItems.put(material, junkItems.get(material) + quantity);
                }

                for (Map.Entry<String, Long> stringLongEntry : keyItems.entrySet()) {
                    String currentMaterial = stringLongEntry.getKey();
                    long currentQuantity = stringLongEntry.getValue();

                    if (currentQuantity >= 250) {
                        switch (currentMaterial) {
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                shadowmourne = true;
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                valanyr = true;
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                dragonwrath = true;
                                break;
                        }

                        break;
                    }
                }

                if (shadowmourne || valanyr || dragonwrath) {
                    hasBroken = true;
                    break;
                }
            }

            if (hasBroken)
                break;
        }

/*
Shadowmourne – requires 250 Shards;
Valanyr – requires 250 Fragments;
Dragonwrath – requires 250 Motes;
 */

        if (shadowmourne) {
            keyItems.put("shards", keyItems.get("shards") - 250L);
        } else if (valanyr) {
            keyItems.put("fragments", keyItems.get("fragments") - 250L);
        } else if (dragonwrath) {
            keyItems.put("motes", keyItems.get("motes") - 250L);
        }

        keyItems.entrySet().stream()
                .sorted((c1, c2) -> keyItems.get(c2.getKey()).compareTo(keyItems.get(c1.getKey())))
                .forEach(item -> System.out.printf("%s: %d\n", item.getKey(), item.getValue()));

        for (Map.Entry<String, Long> stringLongEntry : junkItems.entrySet()) {
            System.out.println(stringLongEntry.getKey() + ": " + stringLongEntry.getValue());
        }
    }

    private static boolean isKeyItem(String material) {
        if (material.equals("shards") || material.equals("fragments") || material.equals("motes"))
            return true;

        return false;
    }
}
