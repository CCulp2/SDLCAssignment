import java.util.ArrayList;

public class StringSanitizer {

    public static String removeHTML(String lineOfFile ) {
        return lineOfFile.replaceAll("<[^>]*>", "");

    }

    public static String removePunctuation(String lineOfFile) {
        // TODO: Add pattern matching for more entity codes besides just mdash
        String sanitizedLine = lineOfFile.replaceAll("&mdash;", " ");
        sanitizedLine = sanitizedLine.replaceAll("[^A-Za-z0-9\\s]", "");
        return sanitizedLine;
    }

    public static ArrayList<String> sanitizeAndArrayList(String s) {
        String[] sArray;
        ArrayList<String> sArrayList = new ArrayList<String>();

        s = StringSanitizer.removeHTML(s);
        s = StringSanitizer.removePunctuation(s);
        //sArray = s.split(" ");
        sArray = s.split("\\s+");
        for(String word : sArray) {
            if (!word.isEmpty()) {
                sArrayList.add(word);
            }
        }
        return sArrayList;
    }
}
