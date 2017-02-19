import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p04 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Long> scoreByPlayer = new LinkedHashMap<>();
        Map<String, List<Player>> duelsByPlayer = new LinkedHashMap<>();

        String command = in.readLine();
        while (!"osu!".equals(command)) {
            String[] commandArgs = command.trim().split("<->");
            String[] firstPlayerArgs = commandArgs[0].trim().split("\\s+");
            String[] secondPlayerArgs = commandArgs[1].trim().split("\\s+");

            String firstPlayerName = firstPlayerArgs[1];
            long firstPlayerScore = Long.parseLong(firstPlayerArgs[0]);

            String secondPlayerName = secondPlayerArgs[0];
            long secondPlayerScore = Long.parseLong(secondPlayerArgs[1]);

            long difference = Math.abs(firstPlayerScore - secondPlayerScore);

            if (firstPlayerScore > secondPlayerScore) { // add to first player
                if (!scoreByPlayer.containsKey(firstPlayerName)) {
                    scoreByPlayer.put(firstPlayerName, difference);
                } else {
                    scoreByPlayer.put(firstPlayerName, scoreByPlayer.get(firstPlayerName) + difference);
                }

                if (!scoreByPlayer.containsKey(secondPlayerName)) {
                    scoreByPlayer.put(secondPlayerName, -difference);
                } else {
                    scoreByPlayer.put(secondPlayerName, scoreByPlayer.get(secondPlayerName) - difference);
                }
            } else {                                    // add to second player
                if (!scoreByPlayer.containsKey(firstPlayerName)) {
                    scoreByPlayer.put(firstPlayerName, -difference);
                } else {
                    scoreByPlayer.put(firstPlayerName, scoreByPlayer.get(firstPlayerName) - difference);
                }

                if (!scoreByPlayer.containsKey(secondPlayerName)) {
                    scoreByPlayer.put(secondPlayerName, difference);
                } else {
                    scoreByPlayer.put(secondPlayerName, scoreByPlayer.get(secondPlayerName) + difference);
                }
            }

            Player firstPlayer;
            Player secondPlayer;
            if (firstPlayerScore > secondPlayerScore) {
                firstPlayer = new Player(firstPlayerName, -difference);          // check if difference is 0
                secondPlayer = new Player(secondPlayerName, difference);
            } else {
                firstPlayer = new Player(firstPlayerName, difference);           // check if difference is 0
                secondPlayer = new Player(secondPlayerName, -difference);
            }

            if (!duelsByPlayer.containsKey(firstPlayerName)) {
                List<Player> duels = new ArrayList<>();
                duels.add(secondPlayer);

                duelsByPlayer.put(firstPlayerName, duels);
            } else {
                List<Player> duels = duelsByPlayer.get(firstPlayerName);
                duels.add(secondPlayer);

                duelsByPlayer.put(firstPlayerName, duels);
            }

            if (!duelsByPlayer.containsKey(secondPlayerName)) {
                List<Player> duels = new ArrayList<>();
                duels.add(firstPlayer);

                duelsByPlayer.put(secondPlayerName, duels);
            } else {
                List<Player> duels = duelsByPlayer.get(secondPlayerName);
                duels.add(firstPlayer);

                duelsByPlayer.put(secondPlayerName, duels);
            }

            command = in.readLine();
        }

        scoreByPlayer.entrySet().stream()
                .sorted((p1, p2) -> Long.compare(p2.getValue(), p1.getValue()))
                .forEach(p -> {
                    System.out.printf("%s - (%d)%n", p.getKey(), p.getValue());

                    List<Player> duels = duelsByPlayer.get(p.getKey());
                    for (Player duel : duels) {
                        System.out.println("*   " + duel.getName() + " <-> " + duel.getDifference());
                    }
                });
    }

    static class Player {
        private String name;
        private long difference;

        public Player(String name, long difference) {
            this.setName(name);
            this.setDifference(difference);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getDifference() {
            return difference;
        }

        public void setDifference(long difference) {
            this.difference = difference;
        }
    }
}
