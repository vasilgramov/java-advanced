import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p05_academyGraduation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeMap<String, Double> scoreByStudent = new TreeMap<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            double score = 0.0;
            String[] scores = in.nextLine().split("\\s+");

            for (int j = 0; j < scores.length; j++) {
                score += Double.parseDouble(scores[j]);
            }

            double avgScore = score / scores.length;
            scoreByStudent.put(name, avgScore);
        }

        for (Map.Entry<String, Double> stringDoubleEntry : scoreByStudent.entrySet()) {
            System.out.printf("%s is graduated with %s\n", stringDoubleEntry.getKey(), stringDoubleEntry.getValue());
        }
    }
}
