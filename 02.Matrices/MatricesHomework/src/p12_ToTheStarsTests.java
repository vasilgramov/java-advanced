import java.util.Scanner;

public class p12_ToTheStarsTests {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] firstStar = in.nextLine().split("\\s+");
        String[] secondStar = in.nextLine().split("\\s+");
        String[] thirdStar = in.nextLine().split("\\s+");

        double[][] starsArgs = new double[3][2];
        starsArgs[0][0] = Double.parseDouble(firstStar[1]) - 1;
        starsArgs[0][1] = Double.parseDouble(firstStar[2]) - 1;

        starsArgs[1][0] = Double.parseDouble(secondStar[1]) - 1;
        starsArgs[1][1] = Double.parseDouble(secondStar[2]) - 1;

        starsArgs[2][0] = Double.parseDouble(thirdStar[1]) - 1;
        starsArgs[2][1] = Double.parseDouble(thirdStar[2]) - 1;

        String[] starNames = new String[3];
        starNames[0] = firstStar[0].toLowerCase();
        starNames[1] = secondStar[0].toLowerCase();
        starNames[2] = thirdStar[0].toLowerCase();


        String[] playerArgs = in.nextLine().split("\\s+");
        double playerRow = Double.parseDouble(playerArgs[0]);
        double playerCol = Double.parseDouble(playerArgs[1]);

        int turns = Integer.parseInt(in.nextLine());
        for (int i = 0; i <= turns; i++) {
            double playerX = playerRow;
            double playerY = playerCol + i;

            boolean hasFound = false;
            for (int j = 0; j < starsArgs.length; j++) {
                double starX1 = starsArgs[j][0];
                double starY1 = starsArgs[j][1];
                double starX2 = starX1 + 2;
                double starY2 = starY1 + 2;

                if (isInsideStar(playerX, playerY, starX1, starY1, starX2, starY2)) {
                    System.out.println(starNames[j]);
                    hasFound = true;
                    break;
                }
            }

            if (!hasFound)
                System.out.println("space");
        }
    }

    private static boolean isInsideStar(double playerX, double playerY, double starX1, double starY1, double starX2, double starY2) {
        if (playerX >= starX1 && playerX <= starX2 && playerY >= starY1 && playerY <= starY2)
            return true;

        return false;
    }
}
