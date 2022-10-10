import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class TextAreaController implements Initializable {

    @FXML
    private TextArea countableTextBox;

    private StringProperty textProperty;
    private WordCountHelper helper;
    private final SharedWordCount sharedWordCount = SharedWordCount.getInstance();
    private CountTableController countTableController;

    public void setTableController(CountTableController countTableController) {
        this.countTableController = countTableController;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StringProperty textProperty = countableTextBox.textProperty();
        helper = new WordCountHelper();
        textProperty.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
//                if (t1.endsWith(" ") || t1.endsWith("\n")) {
                    ObservableList<WordCount> wordList = helper.textAreaMap(t1);
                    sharedWordCount.setWordCount(wordList);
                    countTableController.refreshList();
//                }
            }
        });
    }
}
