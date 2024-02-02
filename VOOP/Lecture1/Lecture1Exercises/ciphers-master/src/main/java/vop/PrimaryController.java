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
    void decrypt(ActionEvent event) {

    }

    @FXML
    private RadioButton button;

    @FXML
    public void initialize(){
        msg = new TextField();
        decryptText = new TextField();

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
        System.out.println("Hello");
        System.out.println(button);


        RadioButton button1 = (RadioButton) group.getSelectedToggle();
        System.out.println(rBA);

        if (button != null && button.getUserData() == (Integer) 1){
            AbstractCipher atbash = new AtbashCipher();
            atbash.encrypt(msg.getText());
            System.out.println("Hello");
        } else {
            AbstractCipher atbash = new CaesarCipher((Integer) spinner.getValue());
            atbash.encrypt(msg.getText());
        }
    }

}