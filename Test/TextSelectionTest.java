import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TextSelectionTest {



    @Test
    void getText() throws IOException {
        String beginningText = "<body>";
        String endingText = "</body>";
        String cleanString = "This should be returned with no issue";

        String[] cleanArray = cleanString.split(" ");
        ArrayList<String> cleanArrayList = new ArrayList<>();
        for (String word : cleanArray) {
            cleanArrayList.add(word);
        }

        File testFile = new File("test/testFile.html");
        TextSelection textSelection = new TextSelection(testFile, beginningText, endingText);
        assertEquals(cleanArrayList, textSelection.getText());
    }
}