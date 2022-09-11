import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCountMap {
    Map<String, Integer> wordCount;
    LinkedHashMap<String, Integer> sortedWordCount;

    public WordCountMap() {
        wordCount = new HashMap<>();
        sortedWordCount = new LinkedHashMap<>();
    }

//    public addWord(): Check to see if word is in list. If it is, increment count. If not, add word and count 1.
    public void addWord(String wordToAdd) {
        String word = wordToAdd.toLowerCase();

        if (wordCount.containsKey(word)) {
            int count = wordCount.get(word);
            wordCount.put(word, count + 1);
        } else {
            wordCount.put(word, 1);
        }
    }
//    public displayTop20: Display the top 20 words counted in descending order
    public void displayTop20() {
        LinkedHashMap<String, Integer> sorted = sortWordCountMap(wordCount, sortedWordCount);
        sorted.entrySet().stream().limit(20).forEach(w -> {
            // TODO: Whatever neato print we want to do here
        });
    }

//    public displayTopX: Displays number of values asked for
    public void displayTopX(int numberToDisplay) {
        LinkedHashMap<String, Integer> sorted = sortWordCountMap(wordCount, sortedWordCount);
        sorted.entrySet().stream().limit(numberToDisplay).forEach(w -> {
            // TODO: Whatever neato print we want to do here.
        });

    }

//    private sortWordCountMap(): Sort the word count map in descending order
    private LinkedHashMap<String, Integer> sortWordCountMap(Map<String, Integer> wordCount, LinkedHashMap<String, Integer> sortedWordCount) {
        wordCount.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedWordCount.put(x.getKey(), x.getValue()));
        return sortedWordCount;
    }
}
