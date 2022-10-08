import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class fxmlLoader {
    Pane view;
    FXMLLoader loader = new FXMLLoader();

    public Pane getView(URL viewToGet) {
        try {
           Pane view = loader.load(viewToGet);
           return view;

        } catch (Exception e) {
            System.out.println("Exception is: " + e);
            e.printStackTrace();
            Pane view = null;
        }
        return view;
    }
}
