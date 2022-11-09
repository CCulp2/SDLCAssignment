import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StringSanitizerTest {

    @Test
    void removeHTML() {
        String htmlLadenString = "<h1>This <em>should</em> return this sentence without HTML</h1>";
        String cleanSentence = "This should return this sentence without HTML";
        assertEquals(cleanSentence, StringSanitizer.removeHTML(htmlLadenString));
    }

    @Test
    void removePunctuation() {
        String punctString = "This.. should!!$@# not(*#)($* have!)@()@$*)#$*( any,,,,, punctuation.";
        String unPunctString = "This should not have any punctuation";
        assertEquals(unPunctString, StringSanitizer.removePunctuation(punctString));
    }

    @Test
    void sanitizeAndArrayList() {
        String unArrayedMessyString = "<h1>This#$%# <em>should!!!!!</em> return$%#$ this,,,.. sentence, without HTML</h1>";
        String cleanString = "This should return this sentence without HTML";
        String[] cleanArray = cleanString.split(" ");
        ArrayList<String> cleanArrayList = new ArrayList<>();
        for (String word : cleanArray) {
            cleanArrayList.add(word);
        }

        assertEquals(cleanArrayList, StringSanitizer.sanitizeAndArrayList(unArrayedMessyString));

    }
}