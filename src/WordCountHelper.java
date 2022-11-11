import javafx.collections.ObservableList;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class WordCountHelper {

    private WordCountMap wordCountMap;
    private WordDb wordDb;


    public WordCountHelper() {
        wordCountMap = new WordCountMap();
        wordDb = new WordDb();
    }

    public ObservableList<WordCount> ravenMap() {
        String DEFAULT_START_OF_SELECTION = "<h1>";
        String DEFAULT_END_OF_SELECTION = "</div>";
        File DEFAULT_FILE_TO_READ = new File("src/1065-h.htm");
        ArrayList<String> arrayOfWords;
        WordCountMap wordCountMap = new WordCountMap();
        LinkedHashMap<String, Integer> sorted;
        ObservableList<WordCount> wordCountList;


        TextSelection text = new TextSelection(DEFAULT_FILE_TO_READ, DEFAULT_START_OF_SELECTION, DEFAULT_END_OF_SELECTION);
        arrayOfWords = text.getText();
        wordDb.addListOfWords(arrayOfWords);
        return wordDb.getTop20Observable();
//        wordCountMap.addListOfWords(arrayOfWords);
//        sorted = wordCountMap.returnTop20();
//        wordCountList = wordCountMap.getObservableWordCountList(sorted);

//        return wordCountList;
    }

    public ObservableList<WordCount> textAreaMap(String s) {
        wordCountMap.clearMap();
        ArrayList<String> sArrayList = StringSanitizer.sanitizeAndArrayList(s);
        wordCountMap.addListOfWords(sArrayList);
        LinkedHashMap<String, Integer> sortedList = wordCountMap.returnTop20();
        return wordCountMap.getObservableWordCountList(sortedList);
    }

}
