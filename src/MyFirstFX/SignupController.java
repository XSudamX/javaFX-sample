package MyFirstFX;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SignupController {

    @FXML
    private TextField FName;
    @FXML
    private TextField LName;
    @FXML
    private TextField Age;
    @FXML
    private TextField BDay;
    @FXML
    private TextField Gender;
    @FXML
    private TextField CivilStatus;
    @FXML
    private TextField Country;
    @FXML
    private TextField Email;
    @FXML
    private TextField Mobile;
    @FXML
    private TextField UName;
    @FXML
    private TextField Password;
    @FXML
    private TextField ConfirmPWord;
    @FXML
    private Label signUpErrorField;


    /**
     * Called onAction of GoBack button, loads the login view again
     *
     * @param actionEvent - onAction event of Go Back Button
     * @throws Exception - Default Exception
     */
    @FXML
    public void goBack(javafx.event.ActionEvent actionEvent) throws Exception {

        // Creates a new stage object with the login fxml view
        Stage prevStage = new Stage();
        Parent loginNode = FXMLLoader.load(getClass().getResource("login.fxml"));
        prevStage.setTitle("Login");
        prevStage.setScene(new Scene(loginNode));
        prevStage.show();

        //Closes the previous stage
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }

    /**
     * Clears all the text fields
     */
    @FXML
    public void clearAll() {
        FName.setText("");
        LName.setText("");
        Age.setText("");
        BDay.setText("");
        Gender.setText("");
        CivilStatus.setText("");
        Country.setText("");
        Email.setText("");
        Mobile.setText("");
        UName.setText("");
        Password.setText("");
        ConfirmPWord.setText("");
    }

    /**
     * Validates the form
     * Opens Success view
     * @param actionEvent - onAction event of Submit Button
     * @throws Exception - Default Exception
     */
    public void submit(javafx.event.ActionEvent actionEvent) throws Exception {

        //Makes sure the user can only submit if none of the fields are empty
        if (!(
        FName.getText().equals("") ||
        LName.getText().equals("") ||
        Age.getText().equals("") ||
        BDay.getText().equals("") ||
        Gender.getText().equals("") ||
        CivilStatus.getText().equals("") ||
        Country.getText().equals("") ||
        Email.getText().equals("") ||
        Mobile.getText().equals("") ||
        UName.getText().equals("") ||
        Password.getText().equals("") ||
        ConfirmPWord.getText().equals("")
        )) {
            // Creates a new stage object with the signupSuccess fxml view
            Stage newStage = new Stage();
            Parent successNode = FXMLLoader.load(getClass().getResource("successSignup.fxml"));
            newStage.setTitle("Success");
            newStage.setScene(new Scene(successNode));
            newStage.show();

            //Closes the previous stage
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();
        } else {
            signUpErrorField.setText("Please fill in all the fields to continue!");
        }

    }
}
