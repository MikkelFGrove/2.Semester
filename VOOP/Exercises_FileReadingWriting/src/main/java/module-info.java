module org.example.exercises_filereadingwriting {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.exercises_filereadingwriting to javafx.fxml;
    exports org.example.exercises_filereadingwriting;
}