import java.util.ArrayDeque;
import java.util.Scanner;

public class p06_robotics {
    static long time = 0L;
    static ArrayDeque<Robot> robots = new ArrayDeque<>();
    static ArrayDeque<String> products = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] robotsData = in.nextLine().split(";");
        String[] timeArgs = in.nextLine().split(":");

        getStartTime(timeArgs);

        getRobotsData(robotsData);

        String command = in.nextLine();
        if (command.equals("End"))
            return;

        time++;
        boolean shouldRead = true;
        while (true) {
            if (!shouldRead && products.size() == 0)
                return;

            String currentProduct = new String();
            if (shouldRead)
                currentProduct = command;
            else
                currentProduct = products.removeFirst();

            boolean hasFound = false;
            for (Robot robot : robots) {
                if (robot.getTime() <= time) {
                    robot.setProduct(currentProduct);
                    robot.setTime(time);
                    System.out.println(robot);
                    robot.setTime(time + robot.getProcessTime());
                    hasFound = true;
                    break;
                }
            }

            if (!hasFound)
                products.addLast(currentProduct);

            if (shouldRead)
                command = in.nextLine();

            if (command.equals("End"))
                shouldRead = false;

            time++;
        }
    }

    private static void getStartTime(String[] timeArgs) {
        long hours = Long.parseLong(timeArgs[0]);
        long mins = Long.parseLong(timeArgs[1]);
        time = Long.parseLong(timeArgs[2]);

        mins += hours * 60;
        time += mins * 60;
    }

    private static void getRobotsData(String[] robotsData) {
        for (String currentRobot : robotsData) {
            String[] currentRobotArgs = currentRobot.split("-");
            String  name = currentRobotArgs[0];
            int processTime = Integer.parseInt(currentRobotArgs[1]);

            Robot robot = new Robot(name, processTime, time);
            robots.addLast(robot);
        }
    }

    private static class Robot implements Comparable<Robot> {
        private String name;
        private long processTime;
        private long time;
        private String product;

        public Robot(String name, long processTime) {
            this.setName(name);
            this.setProcessTime(processTime);

            this.setTime(p06_robotics.time);
        }

        public Robot(String name, long processTime, long time) {
            this.setName(name);
            this.setProcessTime(processTime);

            this.setTime(time);
        }

        public String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        public long getProcessTime() {
            return processTime;
        }

        private void setProcessTime(long processTime) {
            this.processTime = processTime;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        @Override
        public int compareTo(Robot robot) {
            if (this.getTime() > robot.getTime())
                return 1;
             else if (this.getTime() < robot.getTime())
                 return -1;

             return 0;
        }

        @Override
        public String toString() {
            long currentSeconds = this.getTime();
            long hours = ((int) (currentSeconds / 3600)) % 24;
            long remainder = currentSeconds % 3600;
            long mins = remainder / 60;
            currentSeconds  = remainder % 60;

            String hoursToPrint = hours <= 9 ? "0" + Long.toString(hours) : Long.toString(hours);
            String minsToPrint = mins <= 9 ? "0" + Long.toString(mins) : Long.toString(mins);
            String secondsToPrint = currentSeconds <= 9 ? "0" + Long.toString(currentSeconds) : Long.toString(currentSeconds);

            return this.getName() + " - " + this.getProduct() + " [" + hoursToPrint + ":" + minsToPrint + ":" + secondsToPrint + "]";
        }
    }
}