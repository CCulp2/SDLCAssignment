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

    ObservableList<WordCount> wordList = FXCollections.observableArrayList();

    public void initData(ObservableList<WordCount> wordCount) {
        wordList = wordCount;
        countTable.setItems(wordList);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wordCol.setCellValueFactory(new PropertyValueFactory<WordCount, String>("word"));
        countCol.setCellValueFactory(new PropertyValueFactory<WordCount, Integer>("count"));
        System.out.println("init");
    }
}
