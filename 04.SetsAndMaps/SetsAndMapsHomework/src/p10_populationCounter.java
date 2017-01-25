import java.util.*;

public class p10_populationCounter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedHashMap<String, Long> populationByCountry = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Long>> populationByCityByCountry = new LinkedHashMap<>();

        String command = in.nextLine();
        while (!"report".equals(command)) {
            String[] commandArgs = command.split("\\|");
            String country = commandArgs[1];
            String city = commandArgs[0];
            long population = Long.parseLong(commandArgs[2]);

            if (!populationByCityByCountry.containsKey(country)) {
                populationByCityByCountry.put(country, new LinkedHashMap<>());
                populationByCountry.put(country, 0L);
            }

            populationByCountry.put(country, populationByCountry.get(country) + population);

            LinkedHashMap<String, Long> currentHashMap = populationByCityByCountry.get(country);
            if (!currentHashMap.containsKey(city)) {
                currentHashMap.put(city, 0L);
            }

            currentHashMap.put(city, currentHashMap.get(city) + population);

            populationByCityByCountry.put(country, currentHashMap);

            command = in.nextLine();
        }

        populationByCityByCountry.entrySet().stream()
                .sorted((c1,c2)-> populationByCountry.get(c2.getKey()).compareTo(populationByCountry.get(c1.getKey())))
                .forEach(country ->{
                    System.out.printf("%s (total population: %d)\n",country.getKey(), populationByCountry.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1,t2)-> t2.getValue().compareTo(t1.getValue())).forEach(city ->{
                        System.out.format("=>%s: %d\n", city.getKey(),city.getValue());
                    });
                });
    }
}
