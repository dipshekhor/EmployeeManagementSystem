module com.example.employeemanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires fontawesomefx;


    opens com.example.employeemanagementsystem to javafx.fxml;
    exports com.example.employeemanagementsystem;
}