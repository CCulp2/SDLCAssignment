public class StringSanitizer {

    public static String removeHTML(String lineOfFile ) {
        String sanitizedLine = lineOfFile.replaceAll("<[^>]*>", "");
        return sanitizedLine;
    }

    public static String removePunctuation(String lineOfFile) {
        String sanitizedLine = lineOfFile.replaceAll("\\p{Punct}", "");
        return sanitizedLine;
    }

}
