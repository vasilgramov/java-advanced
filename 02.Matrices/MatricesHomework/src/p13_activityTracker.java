import java.util.*;

public class p13_activityTracker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        SortedMap<Integer, HashMap<String, Integer>> distanceByNameByMonth = new TreeMap<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] inputArgs = in.nextLine().split("\\/|\\s+");
//            System.out.println(Arrays.toString(inputArgs));

            String name = inputArgs[3];
            int month = Integer.parseInt(inputArgs[1]);
            int distance = Integer.parseInt(inputArgs[4]);

            if (!distanceByNameByMonth.containsKey(month)) {
                distanceByNameByMonth.put(month, new HashMap<>());
            }

            if (!distanceByNameByMonth.get(month).containsKey(name)) {
                distanceByNameByMonth.get(month).put(name, 0);
            }

            HashMap<String, Integer> currentHashSet = distanceByNameByMonth.get(month);
            currentHashSet.put(name, currentHashSet.get(name) + distance);
            distanceByNameByMonth.put(month, currentHashSet);
        }


        for (Integer month : distanceByNameByMonth.keySet()) {
            System.out.print(month + ": ");
            boolean isFirst = true;


            HashMap<String, Integer> currentHashSet = distanceByNameByMonth.get(month);
            Map<String, Integer> treeMap = new TreeMap<String, Integer>(currentHashSet);
            for (Map.Entry<String, Integer> entry : treeMap.entrySet())
            {
                if (isFirst) {
                    System.out.print(entry.getKey() + "(" + entry.getValue() + ")");
                    isFirst = false;
                } else {
                    System.out.print(", " + entry.getKey() + "(" + entry.getValue() + ")");
                }
            }

            System.out.println();
        }
    }
}
