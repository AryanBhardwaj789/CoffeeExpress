import java.io.File;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SignupController extends UserController {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private Button backToLoginBtn;

    @FXML
    private void backToLoginBtnOnAction(ActionEvent e) throws Exception {
        if (nameTextField.getText().isBlank() == false && emailTextField.getText().isBlank() == false &&
                usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
            displayMessage("Thanks For Creating Account!");
            switchScene("login.fxml");
            try {
                File file = new File("UsernameCredentials.txt");
                PrintWriter pw = new PrintWriter(file);
                pw.println(usernameTextField.getText().toString());
                pw.println(passwordPasswordField.getText().toString());
                pw.close();
            } catch (Exception ex) {
                System.out.println("Can't write file");
            }
        } else {
            displayMessage("Please enter the credentials.");
        }
    }
}
