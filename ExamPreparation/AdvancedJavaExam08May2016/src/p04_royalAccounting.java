import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p04_royalAccounting {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^[A-Za-z]+;\\-?[0-9]+;\\-?[0-9]+(\\.[0-9]+)?;[A-Za-z]+$");

        Set<String> employees = new HashSet<>();

        Map<String, List<Employee>> employeesByTeam = new HashMap<>();

        String command = in.readLine();
        while (!"Pishi kuf i da si hodim".equals(command)) {
            Matcher matcher = pattern.matcher(command);

            if (!matcher.find()) {
                command = in.readLine();
                continue;
            }

            String[] commandArgs = command.split(";");

            String employeeName = commandArgs[0];
            int workHoursPerDay = Integer.parseInt(commandArgs[1]);
            double dailyPayment = Double.parseDouble(commandArgs[2]);
            String team = commandArgs[3];

            if (employees.contains(employeeName)) {
                command = in.readLine();
                continue;
            }

            employees.add(employeeName);

            Employee employee = new Employee(employeeName, dailyPayment, workHoursPerDay);

            if (!employeesByTeam.containsKey(team)) {
                employeesByTeam.put(team, new ArrayList<>());
            }

            List<Employee> currentEmployees = employeesByTeam.get(team);
            currentEmployees.add(employee);
            employeesByTeam.put(team, currentEmployees);
        }

        employeesByTeam.entrySet().stream()
                .sorted((t1, t2) -> Double.compare(
                        t2.getValue().stream().mapToDouble(e -> e.getMonthlyPayment()).sum(),
                        t1.getValue().stream().mapToDouble(e -> e.getMonthlyPayment()).sum()))
                .forEach(t -> {
                    System.out.println("Team - " + t.getKey());

                    t.getValue().stream()
                            .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                            .sorted((e1, e2) -> Double.compare(e2.getDailyPayment(), e1.getDailyPayment()))
                            .sorted((e1, e2) -> Integer.compare(e2.getWorkHours(), e1.getWorkHours()))
                            .forEach(e -> {
                                System.out.printf("$$$%s - %d - %.6f%n", e.getName(), e.getWorkHours(), e.getDailyPayment());
                            });
                });
    }

    static class Employee {
        private String name;
        private double dailyIncome;
        private int workHours;
        private double monthlyPayment;
        private double dailyPayment;

        public Employee(String name, double dailyIncome, int workHours) {
            this.setName(name);
            this.setDailyIncome(dailyIncome);
            this.setWorkHours(workHours);

            this.setMonthlyPayment(((this.getDailyIncome() * this.getWorkHours()) / 24.0) * 30.0);
            this.setDailyPayment((this.getDailyIncome() * this.getWorkHours()) / 24.0);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getDailyIncome() {
            return dailyIncome;
        }

        public void setDailyIncome(double dailyIncome) {
            this.dailyIncome = dailyIncome;
        }

        public int getWorkHours() {
            return workHours;
        }

        public void setWorkHours(int workHours) {
            this.workHours = workHours;
        }

        public double getMonthlyPayment() {
            return monthlyPayment;
        }

        public void setMonthlyPayment(double monthlyPayment) {
            this.monthlyPayment = monthlyPayment;
        }

        public double getDailyPayment() {
            return dailyPayment;
        }

        public void setDailyPayment(double dailyPayment) {
            this.dailyPayment = dailyPayment;
        }
    }
}
