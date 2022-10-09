import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class mainPaneController implements Initializable{

    @FXML
    private BorderPane mainPane;
    @FXML
    private VBox dataVBox;

    private Boolean isRaven = false;

    @FXML
    private void handleRavenButtonAction(ActionEvent event) {
            URL webView = getClass().getResource("/webView.fxml");
            URL ravenUrl = getClass().getResource("1065-h.htm");
            loadRavenTable();

            try {
                WebView view = FXMLLoader.load(webView);
                view.getEngine().load(ravenUrl.toString());
                mainPane.setCenter(view);
                mainPane.setRight(dataVBox);
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Boy, sure should make an error pane one of these days!");
            }

    }

    @FXML
    private void handleTextButtonAction(ActionEvent event) {


    }

    private void loadRavenTable() {
        if (!isRaven) {
            String DEFAULT_START_OF_SELECTION = "<h1>";
            String DEFAULT_END_OF_SELECTION = "</div>";
            File DEFAULT_FILE_TO_READ = new File("src/1065-h.htm");
            ArrayList<String> arrayOfWords;
            WordCountMap wordCountMap = new WordCountMap();
            LinkedHashMap<String, Integer> sorted;
            ObservableList<WordCount> wordCountList;


            TextSelection text = new TextSelection(DEFAULT_FILE_TO_READ, DEFAULT_START_OF_SELECTION, DEFAULT_END_OF_SELECTION);
            arrayOfWords = text.getText();
            wordCountMap.addListOfWords(arrayOfWords);
            sorted = wordCountMap.returnTop20();
            wordCountList = wordCountMap.getObservableWordCountList(sorted);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CountTable.fxml"));


            try {
                dataVBox.getChildren().add(loader.load());
                CountTableController controller = loader.getController();
                controller.initData(wordCountList);

            } catch (Exception e) {
                System.out.println(e);
            }
            isRaven = true;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
