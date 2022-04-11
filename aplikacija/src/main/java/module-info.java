module com.example.aplikacija {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.aplikacija to javafx.fxml;
    exports com.example.aplikacija;
}