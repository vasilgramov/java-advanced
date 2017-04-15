package app.Repository;

import app.IO.OutputWriter;
import app.StaticData.ExceptionMessages;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by vladix on 4/15/17.
 */
public class RepositoryFilters {

    public static void printFilteredStuents(
            Map<String, List<Integer>> courseData,
            String filterType,
            int numberOfStudents) {

        Predicate<Double> filter = createFilter(filterType);
        if (filter == null) {
            OutputWriter.displayException(ExceptionMessages.INVALID_FILTER);
            return;
        }

        int studentCount = 0;
        for (Map.Entry<String, List<Integer>> stringListEntry : courseData.entrySet()) {
            if (studentCount == numberOfStudents) break;

            String name = stringListEntry.getKey();
            List<Integer> marks = stringListEntry.getValue();
            double avg = getStudentAverageGrade(marks);
            if (filter.test(avg)) {
                OutputWriter.printStudent(name, marks);
                studentCount++;
            }
        }
    }

    private static double getStudentAverageGrade(List<Integer> marks) {
        double averageMark = marks.stream()
                .mapToInt(m -> m)
                .average()
                .getAsDouble();


        double percantage = averageMark / 100;
        double mark = percantage * 4 + 2;

        return mark;
    }

    private static Predicate<Double> createFilter(String filterType) {
        switch (filterType) {
            case "excellent":
                return mark -> mark >= 5.0;
            case "average":
                return mark -> 3.5 <= mark && mark <= 5.0;
            case "poor":
                return mark -> mark < 3.5;
            default:
                return null;
        }
    }

}
