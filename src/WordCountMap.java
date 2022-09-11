import java.util.HashMap;
import java.util.Map;

public class WordCountMap {
    Map<String, Integer> wordCount;

    public WordCountMap() {
        wordCount = new HashMap<>();
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

    }

//    private sortWordCountMap(): Sort the word count map in descending order
    private void sortWordCountMap() {

    }
}
