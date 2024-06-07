package vop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {

    @FXML
    private TextField decryptText;

    @FXML
    private Button dekrypterButton;

    @FXML
    private TextField encryptText;

    @FXML
    private Button krypterButton;

    @FXML
    private TextField msg;

    @FXML
    private RadioButton rBA;

    @FXML
    private RadioButton rBC;

    @FXML
    private Spinner<Integer> spinner;

    @FXML
    private ToggleGroup group;



    @FXML
    private RadioButton button;

    @FXML
    public void initialize(){

        spinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        0,
                        CipherInterface.ALPHABETH.length - 1,
                        CipherInterface.ALPHABETH.length / 2
                )
        );

        group = new ToggleGroup();

        rBA.setToggleGroup(group);
        rBC.setToggleGroup(group);

        rBA.setUserData(1);
        rBC.setUserData(2);
    }

    @FXML
    void encrypt(ActionEvent event) {
        button = (RadioButton) group.getSelectedToggle();

        if (button != null && button.getUserData() == (Integer) 1){
            AbstractCipher atbash = new AtbashCipher();
            encryptText.setText(atbash.encrypt(msg.getText()));
        } else {
            AbstractCipher caesar = new CaesarCipher((Integer) spinner.getValue());
            encryptText.setText(caesar.encrypt(msg.getText()));

        }
    }

    @FXML
    void decrypt(ActionEvent event) {
        button = (RadioButton) group.getSelectedToggle();

        if (button != null && button.getUserData() == (Integer) 1){
            AbstractCipher atbash = new AtbashCipher();
            decryptText.setText(atbash.decrypt(msg.getText()));
        } else {
            AbstractCipher caesar = new CaesarCipher((Integer) spinner.getValue());
            decryptText.setText(caesar.decrypt(msg.getText()));

        }
    }

}