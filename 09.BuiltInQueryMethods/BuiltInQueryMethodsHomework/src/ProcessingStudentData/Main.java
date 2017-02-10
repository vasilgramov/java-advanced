package ProcessingStudentData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Path studentDataPath = Paths.get("/home/vladix/Programmig/JavaAdvanced/09.BuiltInQueryMethods/StudentData.txt");
        List<String> data = new ArrayList<>();

        try {
            data = Files.readAllLines(studentDataPath);

            List<Student> students = new ArrayList<>();
            for (int i = 1; i < data.size(); i++) {
                String[] tokens = data.get(i).split("\\s+");

                String facultyNumber = tokens[0];
                String firstName = tokens[1];
                String lastName = tokens[2];
                String email = tokens[3];
                int age = Integer.parseInt(tokens[4]);
                int group = Integer.parseInt(tokens[5]);
                List<Integer> grades = new ArrayList<>();
                for (int j = 6; j < 10; j++) {
                    grades.add(Integer.parseInt(tokens[j]));
                }
                String phone = tokens[10];

                Student student = new Student(facultyNumber, firstName, lastName, email ,age, group, grades, phone);
                students.add(student);
            }

//            // students from group number 2
//            students.stream()
//                    .filter(s -> s.getGroup() == 2)
//                    .sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName()))
//                    .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));

//            // students by first and last name
//            students.stream()
//                    .filter(s -> s.getFirstName().compareTo(s.getLastName()) < 0)
//                    .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));

//            // students by 18 <= age <= 24
//            students.stream()
//                    .filter(s -> 18 <= s.getAge() && s.getAge() <= 24)
//                    .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getAge()));

//            // sort student first by last name in ascending order and then by first name in descending order
//            students.stream()
//                    .sorted((s1, s2) -> s2.getFirstName().compareTo(s1.getFirstName()))
//                    .sorted((s1, s2) -> s1.getLastName().compareTo(s2.getLastName()))
//                    .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));

//            // filter students that have email @gmail.com
//            students.stream()
//                    .filter(s -> s.getEmail().endsWith("@gmail.com"))
//                    .forEach(s -> System.out.println(s.getFirstName() +  " " + s.getLastName() + " " + s.getEmail()));

//            // filter students by phone (starting with 02 || +3592)
//            students.stream()
//                    .filter(s -> s.getPhone().startsWith("02") || s.getPhone().startsWith("+3592"))
//                    .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getPhone()));

//            // filter students that have at least one '6'
//            students.stream()
//                    .filter(s -> s.getGrades().contains(6))
//                    .forEach(s -> {
//                        System.out.print(s.getFirstName() + " " + s.getLastName() + " ");
//                        s.getGrades().stream()
//                                .sorted((g1, g2) -> Integer.compare(g2, g1))
//                                .forEach(g -> System.out.print(g + " "));
//
//                        System.out.println();
//                    });

//            // filter students that have at least 2 marks under or equal to '3'
//            students.stream()
//                    .filter(s -> {
//                        int weakGradesCount = 0;
//                        for (Integer grade : s.getGrades()) {
//                            if (grade <= 3)
//                                weakGradesCount++;
//                        }
//
//                        if (weakGradesCount >= 2)
//                            return true;
//
//                        return false;
//                    }).sorted((s1, s2) -> Integer.compare(
//                            s1.getGrades().stream().mapToInt(g -> g).sum(),
//                            s2.getGrades().stream().mapToInt(g -> g).sum()))
//                    .forEach(s -> {
//                        System.out.print(s.getFirstName() + " " + s.getLastName() + " ");
//                        s.getGrades().stream()
//                                .sorted()
//                                .forEach(g -> System.out.print(g + " "));
//
//                        System.out.println();
//                    });

            // students by year of enrollment
            Map<Integer, List<Student>> studentsByYear = students.stream()
                    .collect(Collectors.groupingBy(
                            s -> Integer.parseInt(
                                    s.getFacultyNumber().substring(s.getFacultyNumber().length() - 2))));

            studentsByYear.entrySet().stream()
                    .sorted((y1, y2) -> Integer.compare(y1.getKey(), y2.getKey()))
                    .forEach(e -> {
                        System.out.println("20" + e.getKey() + ":");
                        e.getValue().stream()
                                .sorted((n1, n2) ->(n1.getFirstName() + n1.getLastName()).compareTo(n2.getFirstName() + n2.getLastName()))
                                .forEach(n -> System.out.println("-- " + n.getFirstName() + " " + n.getLastName()));
                    });


        } catch (IOException e) { e.printStackTrace(); }
    }
}
