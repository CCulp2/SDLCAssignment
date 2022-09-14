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
}
