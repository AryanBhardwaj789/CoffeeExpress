import java.io.File;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.control.PasswordField;

public class MainController {

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Label signupLabel;

    public void loginButtonOnAction(ActionEvent e) throws Exception{
        if (usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
            try {
                File file = new File("UsernameCredentials.txt");
                Scanner scan = new Scanner(file);
                String username = scan.nextLine();
                String password = scan.nextLine();
                if (username.equals(usernameTextField.getText()) && password.equals(passwordPasswordField.getText())) {
                    loginMessageLabel.setText("Welcome!");
                    Stage stage = (Stage) loginMessageLabel.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("order.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    loginMessageLabel.setText("Invalid username or password.");
                }
            } catch (Exception ex) {
                System.out.println("Can't read file");
            }
        } else {
            loginMessageLabel.setText("Please enter username and password.");
        }
    }

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    
    public void signupLabelOnMouseClicked(MouseEvent event) throws Exception{
        try {
            Stage signupStage = new Stage();
            Pane root = new FXMLLoader().load(getClass().getResource("signup.fxml"));
            signupStage.setScene(new Scene(root, 600, 400));
            signupStage.setTitle("Login");
            signupStage.initStyle(StageStyle.UNDECORATED);
            signupStage.show();
            signupStage.setResizable(false);
            Stage stage = (Stage) signupLabel.getScene().getWindow();
            stage.close();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

}