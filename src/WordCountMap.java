import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.*;

/**
 * WordCountMap provides the mapping of words and their occurrences from an Array of words.<br>
 *
 * */
public class WordCountMap {
    /**
     * A String, Integer map of words and their occurrences.
     */
    private final Map<String, Integer> wordCount;
    /**
     * A sorted map of words and their occurrences.
     */
    private final LinkedHashMap<String, Integer> sortedWordCount;


    public WordCountMap() {
        wordCount = new HashMap<>();
        sortedWordCount = new LinkedHashMap<>();
    }

    /**
     * Calls AddWord on ArrayList of Strings.
     * @param listOfWords an ArrayList of words
     */
    public void addListOfWords(ArrayList<String> listOfWords) {
        for (String word : listOfWords) {
            addWord(word);
        }
    }

    /**
     * Check to see if word is in list. If it is, increment count. If not, add word and count 1.
     *
     * @param wordToAdd an individual word to add.
     */
    public void addWord(String wordToAdd) {
        String word = wordToAdd.toLowerCase();

        if (wordCount.containsKey(word)) {
            int count = wordCount.get(word);
            wordCount.put(word, (count+1));
        } else {
            wordCount.put(word, 1);
        }
    }

    /**
     * Displays the top 20 words counted in descending order to the console.
     */
    public void displayTop20() {
        LinkedHashMap<String, Integer> sorted = sortWordCountMap(wordCount, sortedWordCount);
        System.out.printf("%-10s |%3s%n", "Word", "Count");
        System.out.println("-----------------");
        sorted.entrySet().stream().limit(20).forEach(w ->
                System.out.printf("%-10s |%5s%n", w.getKey(), w.getValue()));
    }

    /**
     * Provides a top 20 list without printing to the console.
     * @return a LinkedHashMap of String, Integer.
     */
    public LinkedHashMap<String, Integer> returnTop20() {
        LinkedHashMap<String, Integer> sorted = sortWordCountMap(wordCount, sortedWordCount);
        return sorted;
    }

    /**
     * Displays a list of words to the console.
     * @param numberToDisplay the number of words to display.
     */
    public void displayTopX(int numberToDisplay) {
        LinkedHashMap<String, Integer> sorted = sortWordCountMap(wordCount, sortedWordCount);
        sorted.entrySet().stream().limit(numberToDisplay).forEach(w ->
                System.out.printf("%-10s |%3s%n", w.getKey(), w.getValue()));

    }

    /**
     * Sorts the WordCount in descending order into a LinkedHashMap
     * @param wordCount the map associated with the class.
     * @param sortedWordCount the HasMap of words and occurrences
     * @return a hashmap of words ordered by their count.
     */
    private LinkedHashMap<String, Integer> sortWordCountMap(Map<String, Integer> wordCount, LinkedHashMap<String, Integer> sortedWordCount) {
        wordCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedWordCount.put(x.getKey(), x.getValue()));
        return sortedWordCount;
    }

    /**
     * Sorts the WordCount in descending order into a ObservableList
     * @param top20 a sorted hashmap of words and their number of occurrences
     * @return an ObservableList of the hashmap that JavaFX can read.
     */
    public ObservableList<WordCount> getObservableWordCountList(LinkedHashMap<String, Integer> top20) {
        ObservableList<WordCount> words = FXCollections.observableArrayList();
        top20.entrySet().stream().limit(20).forEach(w ->
                words.add(new WordCount(w.getKey(), w.getValue())));

        return words;
    }

    /**
     * Resets the count map without destroying the instance of the class.
     */
    public void clearMap() {
        wordCount.clear();
        sortedWordCount.clear();
    }
}
