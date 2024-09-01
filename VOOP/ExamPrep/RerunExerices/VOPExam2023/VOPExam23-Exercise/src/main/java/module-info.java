module com.example.vopexam2023 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vopexam2023 to javafx.fxml;
    exports com.example.vopexam2023;
}