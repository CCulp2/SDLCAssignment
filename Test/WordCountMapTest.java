import javafx.collections.ObservableList;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class WordCountMapTest {

    WordCountMap wordCountMap;
    String dummyString;
    String[] dummyArray;
    ArrayList<String> dummyArrayList;


    @BeforeEach
    void setUp() {
        wordCountMap = new WordCountMap();
        dummyString = "This is a test sentence";
        dummyArray = dummyString.split(" ");
        dummyArrayList = new ArrayList<>();
        for (String word : dummyArray) {
            dummyArrayList.add(word);
        }
    }

    @AfterEach
    void tearDown() {
        dummyString = null;
        dummyArray = null;
        dummyArrayList = null;
    }



    @Test
    void returnTop20() {
        wordCountMap.addListOfWords(dummyArrayList);
        LinkedHashMap<String, Integer> returnedMap = wordCountMap.returnTop20();
        assertTrue(returnedMap.keySet().contains("this"));

    }

    @Test
    void getObservableWordCountList() {
        wordCountMap.addListOfWords(dummyArrayList);
        LinkedHashMap wordLink = wordCountMap.returnTop20();
        ObservableList<WordCount> wordList = wordCountMap.getObservableWordCountList(wordLink);
        assertFalse(wordList.isEmpty());
    }

    @Test
    void clearMap() {
    }
}