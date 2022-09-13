import java.io.File;
import java.util.ArrayList;

public class HTMLWordCounter {
    public static void main(String[] args) {
        final String DEFAULT_START_OF_SELECTION = "<h1>";
        final String DEFAULT_END_OF_SELECTION = "</div>";
        final File DEFAULT_FILE_TO_READ = new File("src/1065-h.htm");

        File inputFile = null;
        String startOfSelection = null;
        String endOfSelection = null;
        ArrayList<String> arrayOfWords;
        WordCountMap wordCountMap = new WordCountMap();

//        Weird bit here for future expansion / allowing file selection.
        if (inputFile == null) {
            inputFile = DEFAULT_FILE_TO_READ;
            startOfSelection = DEFAULT_START_OF_SELECTION;
            endOfSelection = DEFAULT_END_OF_SELECTION;
        } else {

        }

        TextSelection text = new TextSelection(inputFile, startOfSelection, endOfSelection);
        arrayOfWords = text.getText();
        wordCountMap.addListOfWords(arrayOfWords);
        wordCountMap.displayTop20();
//        wordCountMap.displayTopX(100);
    }
}
