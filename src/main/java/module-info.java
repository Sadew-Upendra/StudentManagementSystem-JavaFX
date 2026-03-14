module com.example {
    // Requires JavaFX modules
    requires javafx.controls;
    requires javafx.fxml;
    
    // Requires SQL and SQLite JDBC
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    // Opens packages for JavaFX Reflection (Necessary for FXML and TableView)
    opens com.example.controller to javafx.fxml;
    opens com.example.dto to javafx.base;
    
    // Exports packages to be accessible by other modules if needed
    exports com.example;
    exports com.example.controller;
    exports com.example.dto;
}