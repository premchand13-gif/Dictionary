module com.example.dictionary12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dictionary12 to javafx.fxml;
    exports com.example.dictionary12;
}