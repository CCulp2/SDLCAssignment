import javafx.collections.ObservableList;

public final class SharedWordCount {
    private ObservableList<WordCount> wordCount;
    private final static SharedWordCount INSTANCE = new SharedWordCount();

    private SharedWordCount() {}

    public static SharedWordCount getInstance() {
        return INSTANCE;
    }

    public void setWordCount(ObservableList<WordCount> wordCount) {
        this.wordCount = wordCount;
    }

    public ObservableList<WordCount> getWordCount() {
        return wordCount;
    }
}
