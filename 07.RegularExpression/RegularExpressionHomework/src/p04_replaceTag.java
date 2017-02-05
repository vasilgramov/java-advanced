import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p04_replaceTag {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String regex = "<a href=\".+\">([\\s\\S]+?</a>)?";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        String text = "";

        while(true){
            String input = scan.readLine();
            if ("END".equals(input)){break;}
            text += input + "\n";
        }

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String replacement = matcher.group(0).replace("<a","[URL").replace("</a>","[/URL]").replace(">","]");
            text = text.replace(matcher.group(0), replacement);
        }
        System.out.println(text);
    }
}