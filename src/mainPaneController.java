import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;


import java.net.URL;
import java.util.ResourceBundle;

public class mainPaneController implements Initializable {

    @FXML
    private BorderPane mainPane;
    fxmlLoader loader = new fxmlLoader();

    @FXML
    private void handleRavenButtonAction(ActionEvent event) {
            URL webView = getClass().getResource("/webView.fxml");
            URL ravenUrl = getClass().getResource("1065-h.htm");

            try {
                WebView view = FXMLLoader.load(webView);
                view.getEngine().load(ravenUrl.toString());
                mainPane.setCenter(view);
            } catch (Exception e) {
                System.out.println(e);
            }

    }

    @FXML
    private void handleTextButtonAction(ActionEvent event) {
        URL textView = this.getClass().getResource("textView.fxml");
        mainPane.setCenter(loader.getView(textView));

    }

    @FXML
    private void loadTable(WordCountMap map) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
