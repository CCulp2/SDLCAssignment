import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        DbLoad.load();
        Parent root = FXMLLoader.load(getClass().getResource("MainPane.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("CCulp Word Counter");
        stage.show();
    }
}
