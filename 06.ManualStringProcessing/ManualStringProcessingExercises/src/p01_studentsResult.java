import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class p01_studentsResult {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeMap<String, ArrayList<Double>> notesByName = new TreeMap<>();
        int n = Integer.parseInt(in.nextLine());
        if (n == 0)
            return;

        for (int i = 0; i < n; i++) {
            String[] nameNotes = in.nextLine().split(" - ");
            String name = nameNotes[0];
            String[] notesAsString = nameNotes[1].split(", ");
            ArrayList<Double> notes = new ArrayList<>();
            for (String note : notesAsString) {
                notes.add(Double.parseDouble(note));
            }

            notesByName.put(name, notes);
        }

        System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));
        for (String name : notesByName.keySet()) {
            ArrayList<Double> notes = notesByName.get(name);
            double a1 = notes.get(0);
            double a2 = notes.get(1);
            double a3 = notes.get(2);
            double a4 = (a1 + a2 + a3) / 3;
            System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", name, a1, a2, a3, a4).replace('.', ','));
        }
    }
}
