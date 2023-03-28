module com.lab6.lab6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lab6.compulsory to javafx.fxml;
    exports com.lab6.compulsory;
}