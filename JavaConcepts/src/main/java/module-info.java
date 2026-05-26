module com.example.javaconcepts {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javaconcepts to javafx.fxml;
    exports com.example.javaconcepts;
    opens com.example.codingChallenges to javafx.fxml;
    exports com.example.codingChallenges;
    opens com.example.javaconcepts.collections.List to javafx.fxml;
    exports com.example.javaconcepts.collections.List;
    opens com.example.javaconcepts.collections.Map to javafx.fxml;
    exports com.example.javaconcepts.collections.Map;
    opens com.example.javaconcepts.collections.Set to javafx.fxml;
    exports com.example.javaconcepts.collections.Set;
    opens com.example.javaconcepts.collections.demoEntity to javafx.fxml;
    exports com.example.javaconcepts.collections.demoEntity;
    opens com.example.javaconcepts.collections.iteration to javafx.fxml;
    exports com.example.javaconcepts.collections.iteration;
    opens com.example.javaconcepts.inheritance to javafx.fxml;
    exports com.example.javaconcepts.inheritance;
    opens com.example.javaconcepts.multithreading to javafx.fxml;
    exports com.example.javaconcepts.multithreading;
}