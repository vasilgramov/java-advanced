import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_littleJohn {

    static final String BIG_ARROW = ">>>----->>";
    static final String MEDIUM_ARROW = ">>----->";
    static final String SMALL_ARROW = ">----->";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int bigArrowsCount = 0;
        int mediumArrowsCount = 0;
        int smallArrowsCount = 0;

        for (int i = 0; i < 4; i++) {
            String input = in.readLine();

            int currentBigArrowsCount = 0;
            int currentMediumArrowsCount = 0;
            int currentSmallArrowsCount = 0;

            while (input.contains(BIG_ARROW)) {
                int index = input.indexOf(BIG_ARROW);
                input = input.substring(index + BIG_ARROW.length());
                currentBigArrowsCount++;
            }

            while (input.contains(MEDIUM_ARROW)) {
                int index = input.indexOf(MEDIUM_ARROW);
                input = input.substring(index + MEDIUM_ARROW.length());
                currentMediumArrowsCount++;
            }

            while (input.contains(SMALL_ARROW)) {
                int index = input.indexOf(SMALL_ARROW);
                input = input.substring(index + SMALL_ARROW.length());
                currentSmallArrowsCount++;
            }

            bigArrowsCount += currentBigArrowsCount;
            mediumArrowsCount += currentMediumArrowsCount;
            smallArrowsCount += currentSmallArrowsCount;
        }

        String toProcess = smallArrowsCount + "" + mediumArrowsCount + "" + bigArrowsCount;
        String binary = Integer.toBinaryString(Integer.valueOf(toProcess));
        binary += new StringBuilder(binary).reverse();

        int result = Integer.parseInt(binary, 2);
        System.out.println(result);
    }
}
