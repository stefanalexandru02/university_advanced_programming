module com.lab6.lab6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.swing;
    requires com.fasterxml.jackson.databind;

    opens com.lab6.compulsory to javafx.fxml;
    exports com.lab6.compulsory;
    exports com.lab6.compulsory.helpers;
}