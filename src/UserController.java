import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public abstract class UserController {

    @FXML
    protected Label loginMessageLabel;
    @FXML
    protected TextField usernameTextField;
    @FXML
    protected PasswordField passwordPasswordField;

    protected void displayMessage(String message) {
        loginMessageLabel.setText(message);
    }

    protected void switchScene(String scenePath) throws IOException {
        Stage stage = (Stage) loginMessageLabel.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(scenePath));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
