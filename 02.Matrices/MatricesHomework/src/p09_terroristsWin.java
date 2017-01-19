import java.util.Scanner;

public class p09_terroristsWin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String text = in.nextLine();
        char[] afterExplosion = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '|') {
                int bombPower = 0;
                int indexOfTheEndOfTheBomb = 0;     // ??
                for (int j = i + 1; j < text.length(); j++) {
                    if (text.charAt(j) == '|') {
                        indexOfTheEndOfTheBomb = j;
                        break;
                    }
                    bombPower += text.charAt(j);
                }

                int bombExplosionRadius = bombPower % 10;
                int start = 0;
                int end = text.length() - 1;
                if (i - bombExplosionRadius > start) {
                    start = i - bombExplosionRadius;
                }
                if (indexOfTheEndOfTheBomb + bombExplosionRadius < end) {
                    end = indexOfTheEndOfTheBomb + bombExplosionRadius;
                }

                for (int j = start; j <= end; j++) {
                    afterExplosion[j] = '.';
                }

                i = indexOfTheEndOfTheBomb;
            }
        }

        System.out.printf(new String(afterExplosion));
    }
}
