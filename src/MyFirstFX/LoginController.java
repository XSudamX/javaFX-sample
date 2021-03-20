package MyFirstFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField usernameInput;
    @FXML
    private TextField passwordInput;
    @FXML
    private Label userErrorField;
    @FXML
    private Label passwordErrorField;

    // Temporary store of user credentials
    String StoredUsername = "Sudam";
    String StoredPassword = "123";

    /**
     * Navigates from login window to signup window
     * Closes the login window
     * @param actionEvent - onAction event of Signup Button
     * @throws Exception - Default Exception
     */
    @FXML
    public void navigate(javafx.event.ActionEvent actionEvent)  throws Exception {

        // Creates a new stage object and loads the signup view into it
        Stage newStage = new Stage();
        Parent signupNode = FXMLLoader.load(getClass().getResource("signup.fxml"));
        newStage.setTitle("Signup");
        newStage.setScene(new Scene(signupNode));
        newStage.show();

        //Closes the previous stage
        Stage prevStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        prevStage.close();
    }

    /**
     * Calls the Validation method
     * Checks if the user is authorized to login
     * If he is loads new view into same window
     * If he is not displays error message to user
     * @param actionEvent - onAction event of Sign in Button
     * @throws Exception - Default Exception
     */
    @FXML
    public void authorization(ActionEvent actionEvent) throws Exception {
        validation();
        if ((usernameInput.getText().equalsIgnoreCase(StoredUsername)) && (passwordInput.getText().equals(StoredPassword))) {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Parent successNode = FXMLLoader.load(getClass().getResource("success.fxml"));
            stage.setScene(new Scene(successNode,600,400));
        }else{
            passwordErrorField.setText("Incorrect Username or password!");
        }
    }

    /**
     * Checks if the user input is valid
     */
    @FXML
    public void validation(){
        if (usernameInput.getText().equals("")) {
            userErrorField.setText("Please Enter a Username!");
        }
        if (passwordInput.getText().equals("")) {
            passwordErrorField.setText("Please Enter a Password!");
        }
    }
}