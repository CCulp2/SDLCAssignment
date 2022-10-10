import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;


import java.net.URL;
import java.util.ResourceBundle;

public class mainPaneController implements Initializable{

    @FXML
    private BorderPane mainPane;
    @FXML
    private VBox dataVBox;

    private Boolean isRaven = false;

    @FXML
    private void handleRavenButtonAction(ActionEvent event) {
        if (!isRaven) {
            URL webView = getClass().getResource("/webView.fxml");
            URL ravenUrl = getClass().getResource("1065-h.htm");

            try {
                reset();
                WebView view = FXMLLoader.load(webView);
                view.getEngine().load(ravenUrl.toString());
                mainPane.setCenter(view);
                mainPane.setRight(dataVBox);
                WordCountHelper wordCountHelper = new WordCountHelper();
                ObservableList<WordCount> wordCountList = wordCountHelper.ravenMap();
                loadTable(wordCountList);
                isRaven = true;
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Boy, sure should make an error pane one of these days!");
            }
        }
    }

    @FXML
    private void handleTextButtonAction(ActionEvent event) {
        isRaven = false;
        URL textAreaViewURL = getClass().getResource("/TextArea.fxml");

        try {
            reset();
            mainPane.setRight(dataVBox);
            isRaven = false;
            CountTableController tableController = loadTable();
            FXMLLoader loader = new FXMLLoader(textAreaViewURL);
            TextArea view = loader.load();
            TextAreaController textAreaController = loader.getController();
            textAreaController.setTableController(tableController);
            mainPane.setCenter(view);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void loadTable(ObservableList<WordCount> wordCountList) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CountTable.fxml"));


        try {
            dataVBox.getChildren().add(loader.load());
            CountTableController controller = loader.getController();
            controller.initData(wordCountList);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private CountTableController loadTable() {
        URL countTableUrl = getClass().getResource("CountTable.fxml");
        CountTableController controller = null;


        try {
            FXMLLoader loader = new FXMLLoader(countTableUrl);
            dataVBox.getChildren().add(loader.load());
            controller = loader.getController();
            controller.initData();
            return controller;

        } catch (Exception e) {
            System.out.println(e);
        }
        return controller;

    }

    private void reset() {
        dataVBox.getChildren().clear();
        mainPane.setCenter(null);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
