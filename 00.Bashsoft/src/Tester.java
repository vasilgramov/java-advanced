import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladix on 4/15/17.
 */
public class Tester {

    public static void compareContent(String actualComponent, String expectedOutput) throws IOException {
        OutputWriter.writeMessageOnNewLine("Reading files...");

        String mismatchPath = getMismatchPath(expectedOutput);
        File mismatch = new File(mismatchPath);

        List<String> actualOutputString = readLinesFromFile(actualComponent);
        List<String> expectedOutputString = readLinesFromFile(expectedOutput);

        boolean doesMismatch = compareStrings(actualOutputString, expectedOutputString, mismatchPath);
        if (!doesMismatch) {
            OutputWriter.writeMessageOnNewLine("Files are identical. There is no mismatch.");
        } else {
            List<String> mismatchLines = readLinesFromFile(mismatchPath);
            mismatchLines.stream()
                    .forEach(OutputWriter::writeMessageOnNewLine);
        }
    }

    private static boolean compareStrings(List<String> actualOutputString, List<String> expectedOutputString, String mismatch) throws IOException {
        OutputWriter.writeMessageOnNewLine("Comparing files...");

        boolean doesMismatch = false;

        FileWriter fw = new FileWriter(mismatch);
        BufferedWriter writer = new BufferedWriter(fw);

        for (int i = 0; i < expectedOutputString.size(); i++) {
            String output = "";

            String actual = actualOutputString.get(i);
            String expected = expectedOutputString.get(i);

            if (!actual.equals(expected)) {
                output = String.format("mismatch -> expected {%s}, actual {%s}%n", expected, actual);
                doesMismatch = true;
            } else {
                output = String.format("line match -> %s%n", actual);
            }

            writer.write(output + "\r\n");
        }

        writer.close();
        fw.close();

        return doesMismatch;
    }

    private static List<String> readLinesFromFile(String path) throws IOException {
        List<String> lines = new ArrayList<>();

        File file = new File(path);

        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        String line = reader.readLine();
        while (line != null) {
            lines.add(line);

            line = reader.readLine();
        }

        reader.close();
        fr.close();

        return lines;
    }

    private static String getMismatchPath(String expectedOutput) {
        int index = expectedOutput.lastIndexOf("/");
        String dirPath = expectedOutput.substring(0, index);

        return dirPath + "/03.mismatch.txt";
    }
}
