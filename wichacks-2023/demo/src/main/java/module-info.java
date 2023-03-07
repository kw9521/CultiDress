module com.example {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.api.client;

    opens com.example to javafx.fxml;
    exports com.example;
}
