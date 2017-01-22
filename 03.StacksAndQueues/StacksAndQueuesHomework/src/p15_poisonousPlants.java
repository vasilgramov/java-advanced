import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class p15_poisonousPlants {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> pesticidePlants = new ArrayList<>();
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            pesticidePlants.add(in.nextInt());
        }

        int[] days = new int[n];
        ArrayDeque<Integer> proximityStack = new ArrayDeque<>();
        proximityStack.addFirst(0);

        for (int i = 0; i < pesticidePlants.size(); i++) {
            int maxDays = 0;

            while (proximityStack.size() > 0 && pesticidePlants.get(proximityStack.peekFirst()) >= pesticidePlants.get(i)) {
                maxDays = Math.max(maxDays, days[proximityStack.removeFirst()]);
            }

            if (proximityStack.size() > 0) {
                days[i] = maxDays + 1;
            }

            proximityStack.addFirst(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > max)
                max = days[i];
        }

        System.out.println(max);
    }
}