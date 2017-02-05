import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p06_sentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String searchedWord = in.readLine();

        String regex = "[A-Z][^!|.|?]+\\b" + Pattern.quote(searchedWord) + "\\b[^.|?|!]+[.|!|?]";
        Pattern pattern = Pattern.compile(regex);

        String input = in.readLine();
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            System.out.println(matcher.group().trim());
        }
    }
}
