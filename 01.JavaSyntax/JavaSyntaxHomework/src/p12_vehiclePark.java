import java.util.Scanner;

public class p12_vehiclePark {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] vehiclesInThePark = in.nextLine().split("\\s+");
        String command = in.nextLine();
        int sold = 0;
        while (!command.equals("End of customers!")) {
            String[] commandArgs = command.split("\\s+");
            String currentVehicle = Character.toString(commandArgs[0].charAt(0)).toLowerCase() + commandArgs[2];

            boolean hasFound = false;
            for (int i = 0; i < vehiclesInThePark.length; i++) {
                String vehicle = vehiclesInThePark[i];
                if (vehicle.equals(currentVehicle)) {
                    int price = vehicle.charAt(0) * Integer.parseInt(vehicle.substring(1, vehicle.length()));
                    System.out.println("Yes, sold for " + price + "$");
                    vehiclesInThePark[i] = "";

                    hasFound = true;
                    sold++;
                    break;
                }
            }

            if (!hasFound) {
                System.out.println("No");
            }

            command = in.nextLine();
        }


        boolean isFirst = true;
        System.out.print("Vehicles left: ");
        for (String vehicle : vehiclesInThePark) {
            if (!vehicle.equals("")) {
                if (isFirst) {
                    System.out.print(vehicle);
                    isFirst = false;
                } else {
                    System.out.print(", " + vehicle);
                }
            }
        }

        System.out.println();
        System.out.println("Vehicles sold: " + sold);
    }
}
