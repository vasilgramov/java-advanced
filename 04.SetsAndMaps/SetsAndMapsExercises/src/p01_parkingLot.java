import java.util.HashSet;
import java.util.Scanner;

public class p01_parkingLot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HashSet<String> cars = new HashSet<>();
        String command = in.nextLine();
        while (!command.equals("END")) {
            String[] commandArgs = command.split(",\\s+");
            String commandType = commandArgs[0];
            String carNumber = commandArgs[1];

            if (commandType.equals("IN"))
                cars.add(carNumber);
            else
                cars.remove(carNumber);

            command = in.nextLine();
        }


        if (cars.isEmpty())
            System.out.println("Parking Lot is Empty");
        else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
