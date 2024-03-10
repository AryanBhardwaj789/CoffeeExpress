import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PaymentController {

    ObservableList<String> paymentList = FXCollections.observableArrayList("Credit/Debit Card","Cash","Paypal","Gift Card");

    @FXML
    private Button cancelButton;
    @FXML
    public ChoiceBox paymentChoiceBox;
    @FXML
    private Label amountDisplayLabel;
    @FXML
    private Button confirmButton;

    @FXML
    private void initialize(){
        paymentChoiceBox.setItems(paymentList);
        amountDisplayLabel.setText(String.format("$%.2f",OrderController.amount));
    }

    @FXML
    private void confirmButtonOnAction(ActionEvent e){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("receipt.fxml"));
            Pane root = loader.load();
            ReceiptController receiptController = loader.getController();
            receiptController.paymentMethodLabel.setText(paymentChoiceBox.getValue().toString());
            Stage receiptStage = new Stage();
            receiptStage.setScene(new Scene(root, 600, 400));
            receiptStage.setTitle("Receipt");
            receiptStage.initStyle(StageStyle.UNDECORATED);
            receiptStage.show();
            receiptStage.setResizable(false);
            Stage stage = (Stage) confirmButton.getScene().getWindow();
            stage.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

}
