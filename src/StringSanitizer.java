public class StringSanitizer {

    public String removeHTML(String lineOfFile ) {
        String sanitizedLine = lineOfFile.replaceAll("<[^>]*>", "");
        return sanitizedLine;
    }

    public String removePunctuation(String lineOfFile) {
        String sanitizedLine = lineOfFile.replaceAll("\\p{Punct}", "");
        return sanitizedLine;
    }

}
