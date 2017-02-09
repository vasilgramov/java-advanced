import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class p07_mapDistrict {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Map<String, ArrayList<Integer>> populationByCity = new HashMap<>();

        String[] tokens = in.readLine().split("\\s+");
        for (String token : tokens) {
            String[] cityArgs = token.split(":");
            String city = cityArgs[0];
            int disctrictPopulation = Integer.parseInt(cityArgs[1]);

            populationByCity.putIfAbsent(city, new ArrayList<>());
            populationByCity.get(city).add(disctrictPopulation);
        }

        int minPopulation = Integer.parseInt(in.readLine());
        populationByCity.entrySet().stream()
                .filter(c -> c.getValue().stream().mapToInt(Integer::intValue).sum() >= minPopulation)
                .sorted((c1, c2) -> Integer.compare(
                        c2.getValue().stream().mapToInt(Integer::intValue).sum(),
                        c1.getValue().stream().mapToInt(Integer::intValue).sum()))
                .forEach(c -> {
                    System.out.print(c.getKey() + ": ");
                    c.getValue().stream()
                            .sorted((p1, p2) -> Integer.compare(p2, p1))
                            .limit(5)
                            .forEach(p -> System.out.print(p + " "));

                    System.out.println();
                });
    }
}
