import java.util.*;

public class WordCountMap {
    private Map<String, Integer> wordCount;
    private LinkedHashMap<String, Integer> sortedWordCount;

    public WordCountMap() {
        wordCount = new HashMap<>();
        sortedWordCount = new LinkedHashMap<>();
    }

//    public AddListOfWords(): Input an arrayList of words to check.
    public void addListOfWords(ArrayList<String> listOfWords) {
        for (String word : listOfWords) {
            addWord(word);
        }
    }

//    public addWord(): Check to see if word is in list. If it is, increment count. If not, add word and count 1.
    public void addWord(String wordToAdd) {
        String word = wordToAdd.toLowerCase();

        if (wordCount.containsKey(word)) {
            int count = wordCount.get(word);
            wordCount.put(word, (count+1));
        } else {
            wordCount.put(word, 1);
        }
    }
//    public displayTop20: Display the top 20 words counted in descending order
    public void displayTop20() {
        LinkedHashMap<String, Integer> sorted = sortWordCountMap(wordCount, sortedWordCount);
        System.out.println(String.format("%-10s |%3s", "Word", "Count"));
        System.out.println("-----------------");
        sorted.entrySet().stream().limit(20).forEach(w -> {
            System.out.println(String.format("%-10s |%5s", w.getKey(), w.getValue()));
        });
    }

//    public displayTopX: Displays number of values asked for
    public void displayTopX(int numberToDisplay) {
        LinkedHashMap<String, Integer> sorted = sortWordCountMap(wordCount, sortedWordCount);
        sorted.entrySet().stream().limit(numberToDisplay).forEach(w -> {
            System.out.println(String.format("%-10s |%3s", w.getKey(), w.getValue()));
        });

    }

//    private sortWordCountMap(): Sort the word count map in descending order
    private LinkedHashMap<String, Integer> sortWordCountMap(Map<String, Integer> wordCount, LinkedHashMap<String, Integer> sortedWordCount) {
        wordCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedWordCount.put(x.getKey(), x.getValue()));
        return sortedWordCount;
    }
}
