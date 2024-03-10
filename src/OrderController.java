import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OrderController {

    ObservableList<String> coffeeList = FXCollections.observableArrayList("Americano ($2.50)","Cappuccino ($2.50)","Glace ($2.50)",
                                                                                "Espresso ($2.50)","Mocha ($2.50)","Latte ($2.50)");

    @FXML
    private Button clearFieldBtn;
    @FXML
    private Button orderBtn;
    @FXML
    private Button logoutBtn;
    @FXML
    private TextField quantity;
    @FXML
    private CheckBox whippedCream;
    @FXML
    private CheckBox chocolate;
    @FXML
    private CheckBox nutella;
    @FXML
    private ChoiceBox coffeeChoiceBox;

    public static double amount = 0.0;
    public static int quantityValue;
    public static String coffeeChoice;
    public static boolean whippedCreamSelected;
    public static boolean chocolateSelected;
    public static boolean nutellaSelected;
    
    
    @FXML
    private void initialize(){
        coffeeChoiceBox.setItems(coffeeList);
    }

    @FXML
    public void clear() {
        quantity.setText(null);
        whippedCream.setSelected(false);
        chocolate.setSelected(false);
        nutella.setSelected(false);
        coffeeChoiceBox.getSelectionModel().clearSelection();
    }

    @FXML
    public void order(ActionEvent e) throws Exception{
        quantityValue = Integer.parseInt(quantity.getText());
        coffeeChoice = coffeeChoiceBox.getValue().toString();
        whippedCreamSelected = whippedCream.isSelected();
        chocolateSelected = chocolate.isSelected();
        nutellaSelected = nutella.isSelected();
        int wc=0,c=0,n=0;
        if (whippedCream.isSelected()) {
            wc = 1;
        }
        if (chocolate.isSelected()) {
            c = 1;
        }
        if (nutella.isSelected()) {
            n = 1;
        }
        amount += ((2.50 + (wc * 0.5) + (c * 0.5) + (n * 0.5)) * quantityValue);

         try {
            Stage paymentStage = new Stage();
            Pane root = new FXMLLoader().load(getClass().getResource("payment.fxml"));
            paymentStage.setScene(new Scene(root, 600, 400));
            paymentStage.setTitle("Payment");
            paymentStage.initStyle(StageStyle.UNDECORATED);
            paymentStage.show();
            paymentStage.setResizable(false);
            Stage stage = (Stage) orderBtn.getScene().getWindow();
            stage.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void logout() {
        try {
            Stage loginStage = new Stage();
            Pane root = new FXMLLoader().load(getClass().getResource("login.fxml"));
            loginStage.setScene(new Scene(root, 600, 400));
            loginStage.setTitle("Login");
            loginStage.initStyle(StageStyle.UNDECORATED);
            loginStage.show();
            loginStage.setResizable(false);
            Stage stage = (Stage) logoutBtn.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
