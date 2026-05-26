module com.example.javaconcepts {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javaconcepts to javafx.fxml;
    exports com.example.javaconcepts;
}