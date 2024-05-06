package vop;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;

public class PrimaryController {
    @FXML
    private RadioButton atbashRadio;

    @FXML
    private RadioButton caeserRadio;

    @FXML
    private Spinner<Integer> caeserSpinnter;

    @FXML
    private Button decryptButton;

    @FXML
    private TextField decryptText;

    @FXML
    private Button encryptButton;

    @FXML
    private TextField encryptText;

    @FXML
    private TextField message;

    @FXML
    private ToggleGroup tGroup;

    private CipherInterface cipherInterface;

    @FXML
    void initialize(){
        caeserSpinnter.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        0,
                        CipherInterface.ALPHABETH.length - 1,
                        CipherInterface.ALPHABETH.length / 2
                )
        );
    }

    @FXML
    void cryptHandler(ActionEvent event) {
        Object source = event.getSource();

        if (atbashRadio.isSelected()) {
            cipherInterface = new AtbashCipher();
        } else if (caeserRadio.isSelected()) {
            int keyValue = caeserSpinnter.getValue();
            System.out.println(keyValue);
            cipherInterface = new CaesarCipher(keyValue);
        }

        if (source == encryptButton) {
            encryptText.setText(cipherInterface.encrypt(message.getText()));
        } else if (source == decryptButton) {
            decryptText.setText(cipherInterface.decrypt(encryptText.getText()));
        }

    }


}
