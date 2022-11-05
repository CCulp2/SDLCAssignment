import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CountTableController implements Initializable {

    @FXML
    private TableView<WordCount> countTable;

    @FXML
    private TableColumn<WordCount, Integer> countCol;

    @FXML
    private TableColumn<WordCount, String> wordCol;
    private final SharedWordCount sharedWordCount = SharedWordCount.getInstance();

    ObservableList<WordCount> wordList = FXCollections.observableArrayList();

    /**
     * Initializes the table with a received List of WordCount's and sets the
     * items displayed to the contents of the WordCount, maintaining order.
     * @param wordCountList an ObservableList of type WordCount.
     * @author
     */
    public void initData(ObservableList<WordCount> wordCountList) {
        wordList = wordCountList;
        countTable.setItems(wordList);
    }

    /**
     * Initializes the table with a WordCount list shared between the
     * text area and the table.
     */
    public void initData() {
        countTable.setItems(FXCollections.observableArrayList(sharedWordCount.getWordCount()));
    }

    /**
     * Refreshes the shared WordCount list.
     */
    public void refreshList() {
        countTable.setItems(sharedWordCount.getWordCount());
        countTable.refresh();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wordCol.setCellValueFactory(new PropertyValueFactory<WordCount, String>("word"));
        countCol.setCellValueFactory(new PropertyValueFactory<WordCount, Integer>("count"));
        countTable.setItems(wordList);
    }
}
