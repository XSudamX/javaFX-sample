package MyFirstFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class SuccessController {
    /**
     * Exits the application when onAction event is triggered
     * @param actionEvent - onAction event of Close button
     */
    @FXML
    public void quitApp(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
