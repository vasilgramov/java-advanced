import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p01_royalism {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int indexOfR = 18;

        List<String> royals = new ArrayList<>();
        List<String> nonRoyals = new ArrayList<>();

        String[] names = in.readLine().trim().split("\\s+");
        for (String name : names) {
            int sum = 0;
            for (int i = 0; i < name.length(); i++) {
                sum += name.charAt(i);
            }

            sum %= 26;

            if (sum == indexOfR)
                royals.add(name);
            else
                nonRoyals.add(name);
        }

        if (royals.size() >= nonRoyals.size()) {
            System.out.println("Royalists - " + royals.size());
            for (String royal : royals) {
                System.out.println(royal);
            }

            System.out.println("All hail Royal!");
        } else {
            for (String nonRoyal : nonRoyals) {
                System.out.println(nonRoyal);
            }

            System.out.println("Royalism, Declined!");
        }
    }
}
