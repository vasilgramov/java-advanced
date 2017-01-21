import java.util.ArrayDeque;
import java.util.Scanner;

public class p07_truckTour {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        ArrayDeque<String> petrolDistance = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            petrolDistance.addLast(in.nextLine());
        }

        long index = 0;
        while (true) {
            long petrol = 0;
            String currentCommand = petrolDistance.removeFirst();
            String[] station = currentCommand.split(" ");
            long currentPetrol = Long.parseLong(station[0]);
            long kilometers = Long.parseLong(station[1]);

            petrol += currentPetrol - kilometers;
            if (petrol >= 0) {
                boolean hasSucceeded = true;

                for (String stationData : petrolDistance) {
                    String[] stationArgs = stationData.split("\\s+");
                    long currentPetrolOfTheStation = Long.parseLong(stationArgs[0]);
                    long currentKilometers = Long.parseLong(stationArgs[1]);

                    petrol += currentPetrolOfTheStation - currentKilometers;
                    if (petrol < 0) {
                        hasSucceeded = false;
                        break;
                    }
                }

                if (hasSucceeded) {
                    System.out.println(index);
                    return;
                }else {
                    petrolDistance.addLast(currentCommand);
                }
            } else {
                petrolDistance.addLast(currentCommand);
            }

            index++;
        }
    }
}
