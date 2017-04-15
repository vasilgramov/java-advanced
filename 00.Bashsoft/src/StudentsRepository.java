import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vladix on 4/14/17.
 */
public class StudentsRepository {

    private static boolean isDataInitialized = false;
    private static Map<String, Map<String, List<Integer>>> studentsByCourse;

    private static final String DATA_VALIDATION_PATTERN =
            "([A-Z]{1}[a-zA-Z+#]+_(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)_(?:2014|2015|2016|2017))\\s+([A-Z][a-z]{1,3}[0-9]{2}_[0-9]{2,4})\\s+([0-9]{1,3})";

    public static void initData(String fileName) throws IOException {
        if (isDataInitialized) {
            OutputWriter.displayException(ExceptionMessages.DATA_ALREADY_INITIALIZED);
            return;
        }

        studentsByCourse = new HashMap<>();
        readData(fileName);
    }

    public static void readData(String fileName) throws IOException {
        String filePath = SessionData.currentPath + "/" + fileName;
        List<String> lines  = Files.readAllLines(Paths.get(filePath));

        Pattern pattern = Pattern.compile(DATA_VALIDATION_PATTERN);
        Matcher matcher;

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            matcher = pattern.matcher(line);
            if (!line.isEmpty() && matcher.find()) {
                String[] tokens = line.split("\\s+");
                String course = tokens[0];
                String student = tokens[1];
                int mark = Integer.parseInt(tokens[2]);
                if (mark >= 0 && mark <= 100) {
                    if (!studentsByCourse.containsKey(course)) {
                        studentsByCourse.put(course, new LinkedHashMap<>());
                    }

                    if (!studentsByCourse.get(course).containsKey(student)) {
                        studentsByCourse.get(course).put(student, new ArrayList<>());
                    }

                    studentsByCourse.get(course).get(student).add(mark);
                }
            }
        }

        isDataInitialized = true;
        System.out.println("Data read.");
    }


    public static void getStudentMarksInCourse(String course, String student) {
        if (!isQueryForStudentPossiblе(course, student)) {
            return;
        }

        List<Integer> marks = studentsByCourse.get(course).get(student);
        OutputWriter.printStudent(student, marks);
    }

    public static void getStudentByCourse(String course) {
        if (!isQueryForCoursePossible(course)) {
            return;
        }

        OutputWriter.writeMessageOnNewLine(course + ": ");
        for (Map.Entry<String, List<Integer>> stringListEntry : studentsByCourse.get(course).entrySet()) {
            OutputWriter.printStudent(stringListEntry.getKey(), stringListEntry.getValue());
        }
    }

    private static boolean isQueryForCoursePossible(String courseName) {
        if (!isDataInitialized) {
            OutputWriter.displayException(ExceptionMessages.DATA_NOT_INITIALIZED);
            return false;
        }

        if (!studentsByCourse.containsKey(courseName)) {
            OutputWriter.displayException(String.format(ExceptionMessages.NOT_EXISTING_COURSE, courseName));
            return false;
        }

        return true;
    }

    private static boolean isQueryForStudentPossiblе(String courseName, String studentName) {
        if (!isQueryForCoursePossible(courseName)) {
            return false;
        }

        if (!studentsByCourse.containsKey(studentName)) {
            OutputWriter.displayException(String.format(ExceptionMessages.NOT_EXISTING_STUDENT, studentName));
            return false;
        }

        return true;
    }
}
