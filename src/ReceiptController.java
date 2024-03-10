import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ReceiptController {

    @FXML
    public Label paymentMethodLabel;
    @FXML
    private Label quantityLabel;
    @FXML
    private Label quantityLabel1;
    @FXML
    private Label quantityLabel2;
    @FXML
    private Label quantityLabel3;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label amtLabel;
    @FXML
    private Label amountLabel;
    @FXML
    private Label toppingAmtLabel1;
    @FXML
    private Label toppingAmtLabel2;
    @FXML
    private Label toppingAmtLabel3;
    @FXML
    private Label toppingDescriptionLabel1;
    @FXML
    private Label toppingDescriptionLabel2;
    @FXML
    private Label toppingDescriptionLabel3;
    @FXML
    private Label dateLabel;
    @FXML
    private Button BackBtn;
    
    @FXML
    private void initialize(){
        amountLabel.setText(String.format("$%.2f",OrderController.amount));
        amtLabel.setText(String.format("$%.2f",OrderController.quantityValue * 2.50));
        quantityLabel.setText(""+OrderController.quantityValue);
        descriptionLabel.setText(OrderController.coffeeChoice);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        dateLabel.setText(dateFormat.format(date));

        int toppingIndex = 1;
        if (OrderController.whippedCreamSelected) {
            setTopping(toppingIndex++, "Whipped Cream ($0.50)");
        }
        if (OrderController.chocolateSelected) {
            setTopping(toppingIndex++, "Chocolate ($0.50)");
        }
        if (OrderController.nutellaSelected) {
            setTopping(toppingIndex++, "Nutella ($0.50)");
        }
    }
    
    private void setTopping(int index, String text) {
        switch (index) {
            case 1:
                toppingDescriptionLabel1.setText(text);
                quantityLabel1.setText(""+OrderController.quantityValue);
                toppingAmtLabel1.setText(String.format("$%.2f",OrderController.quantityValue * 0.50));
                break;
            case 2:
                toppingDescriptionLabel2.setText(text);
                quantityLabel2.setText(""+OrderController.quantityValue);
                toppingAmtLabel2.setText(String.format("$%.2f",OrderController.quantityValue * 0.50));
                break;
            case 3:
                toppingDescriptionLabel3.setText(text);
                quantityLabel3.setText(""+OrderController.quantityValue);
                toppingAmtLabel3.setText(String.format("$%.2f",OrderController.quantityValue * 0.50));
                break;
        }
    }

    public void BackButtonOnAction(ActionEvent e) throws IOException {
        Stage stage = (Stage) BackBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("order.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
