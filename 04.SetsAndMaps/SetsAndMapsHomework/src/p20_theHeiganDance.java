import java.util.Scanner;

public class p20_theHeiganDance {
    static final int CLOUD_DAMAGE = 3500;
    static final int ERUPTION_DAMAGE = 6000;

    static double heiganHP = 3000000.0;

    static int playerHP = 18500;
    static int playerRow = 7;
    static int playerCol = 7;
    static boolean playerHasPlague = false;

    static char[][] field = new char[15][15];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double damageToHeigan = Double.parseDouble(in.nextLine());

        while (true) {
            if (playerHasPlague) {
                playerHP -= CLOUD_DAMAGE;
                playerHasPlague = false;

                if (playerHP <= 0) {
                    heiganHP -= damageToHeigan;
                    System.out.printf("Heigan: %.2f\n", heiganHP);
                    System.out.println("Player: Killed by Plague Cloud");
                    System.out.printf("Final position: %d, %d", playerRow, playerCol);
                    return;
                }
            }

            heiganHP -= damageToHeigan;
            if (heiganHP <= 0) {
                System.out.println("Heigan: Defeated!");
                // TODO: check for plague and if player dies also
                System.out.println("Player: " + playerHP);
                System.out.printf("Final position: %d, %d", playerRow, playerCol);
                return;
            }

            String[] commandArgs = in.nextLine().split("\\s+");

            String spell = null;
            int row = 0 ;
            int col = 0;
            try {
                spell = commandArgs[0];
                row = Integer.parseInt(commandArgs[1]);
                col = Integer.parseInt(commandArgs[2]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (row == playerRow && col == playerCol) { // takes damage
                if (spell.equals("Cloud")) {
                    playerHP -= CLOUD_DAMAGE;
                    playerHasPlague = true;
                } else {
                    playerHP -= ERUPTION_DAMAGE;
                }

                if (playerHP <= 0) {
                    System.out.printf("Heigan: %.2f\n", heiganHP);
                    if (spell.equals("Eruption"))
                        System.out.println("Player: Killed by Eruption");
                    else
                        System.out.println("Player: Killed by Plague Cloud");
                    System.out.printf("Final position: %d, %d", playerRow, playerCol);
                    return;
                }
            } else {
                markAttackedCells(row, col);
//                printFiled(field);

                try {
                    // up right down left
                    if (isInMatrix(playerRow - 1, playerCol) && field[playerRow - 1][playerCol] != '@') {
                        playerRow -= 1;
                    } else if (isInMatrix(playerRow, playerCol + 1) && field[playerRow][playerCol + 1] != '@') {
                        playerCol += 1;
                    } else if (isInMatrix(playerRow + 1, playerCol) && field[playerRow + 1][playerCol] != '@') {
                        playerRow += 1;
                    } else if (isInMatrix(playerRow, playerCol - 1) && field[playerRow][playerCol - 1] != '@') {
                        playerCol -= 1;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                field = new char[15][15];
            }
        }
    }

    private static void printFiled(char[][] field) {
        try {
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    System.out.print(field[i][j] + " ");
                }

                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void markAttackedCells(int row, int col) {
        try {
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (isInMatrix(i, j)) {
                        field[i][j] = '@';
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    private static boolean isInMatrix(int row, int col) {
        if (row >= 0 && row < 15 && col >= 0 && col < 15)
            return true;

        return false;
    }
}
