import java.time.Clock;
import java.util.ArrayDeque;
import java.util.Scanner;

public class p06_robotics {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayDeque<Robot> queuedRobots = new ArrayDeque<>();

        String[] robots = in.nextLine().split(";");
        for (int i = 0; i < robots.length; i++) {
            String[] robotArgs = robots[i].split("-");
            String name = robotArgs[0];
            long processTime = Long.parseLong(robotArgs[1]);

            Robot robot = new Robot(name, processTime);
            queuedRobots.addLast(robot);
        }

        String[] time = in.nextLine().split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);

        String command = in.nextLine();
        while (!command.equals("End")) {
            long secondsToAdd = 1L;
            Robot currentRobot = queuedRobots.getFirst();

            currentRobot.setProduct(command);

            seconds += secondsToAdd;


            command = in.nextLine();
        }
    }

    private static class Robot {
        private String name;
        private long processTime;
        private String product;

        public Robot(String name, long processTime) {
            this.setName(name);
            this.setProcessTime(processTime);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getProcessTime() {
            return processTime;
        }

        public void setProcessTime(long processTime) {
            this.processTime = processTime;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }
    }
}

