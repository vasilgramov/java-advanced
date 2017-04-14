import java.util.*;

/**
 * Created by vladix on 4/14/17.
 */
public class StudentsRepository {

    public static boolean isDataInitialized = false;
    public static Map<String, Map<String, List<Integer>>> studentsByCourse;


    public static void initData() {
        if (isDataInitialized) {
            OutputWriter.displayException(ExceptionMessages.DATA_ALREADY_INITIALIZED);
            return;
        }

        studentsByCourse = new HashMap<>();
        readData();
    }

    public static void readData() {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        while (!input.equals("")) {
            String[] tokens = input.split("\\s+");
            String course = tokens[0];
            String student = tokens[1];
            int mark = Integer.parseInt(tokens[2]);

            if (!studentsByCourse.containsKey(course)) {
                studentsByCourse.put(course, new LinkedHashMap<>());
            }

            if (!studentsByCourse.get(course).containsKey(student)) {
                studentsByCourse.get(course).put(student, new ArrayList<>());
            }

            studentsByCourse.get(course).get(student).add(mark);
            input = in.nextLine();
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
