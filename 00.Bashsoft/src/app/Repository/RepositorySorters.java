package app.Repository;

import app.IO.OutputWriter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by vladix on 4/15/17.
 */
public class RepositorySorters {

    public static void printSortedStudents(
            Map<String, List<Integer>> courseData,
            String comparisonType,
            int numberOfStudents) {

        Comparator<Map.Entry<String, List<Integer>>> comparator = (s1, s2)
                -> Double.compare(
                        s1.getValue().stream().mapToInt(x -> x).average().getAsDouble(),
                        s2.getValue().stream().mapToInt(x -> x).average().getAsDouble());
        List<Map.Entry<String, List<Integer>>> sortedStudents = new ArrayList<>();

        sortedStudents = courseData.entrySet().stream()
                .sorted(comparator)
                .limit(numberOfStudents)
                .map(x -> x)
                .collect(Collectors.toList());

        if (comparisonType.equals("descending")) {
            Collections.reverse(sortedStudents);
        }

        for (Map.Entry<String, List<Integer>> sortedStudent : sortedStudents) {
            OutputWriter.printStudent(sortedStudent.getKey(), sortedStudent.getValue());
        }
    }

    private static Comparator<Map.Entry<String, List<Integer>>> createComparator(String comparisonType) {
        switch (comparisonType) {
            case "ascending":
                return (firstStudent, secondStudent) -> {
                    double firstStudentScore = getScore(firstStudent.getValue());
                    double secondStudentScore = getScore(secondStudent.getValue());
                    return Double.compare(firstStudentScore, secondStudentScore);
                };
            case "descending":
                return (firstStudent, secondStudent) -> {
                    double firstStudentScore = getScore(firstStudent.getValue());
                    double secondStudentScore = getScore(secondStudent.getValue());
                    return Double.compare(secondStudentScore, firstStudentScore);
                };
            default:
                return null;
        }
    }

    private static double getScore(List<Integer> value) {
        double total = 0.0;
        for (Integer integer : value) {
            total += integer;
        }

        return total / value.size();
    }

}
