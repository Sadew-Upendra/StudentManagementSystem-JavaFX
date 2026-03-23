module com.example {
    // Requires JavaFX modules
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    
    // Requires SQL and SQLite JDBC
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    requires kernel;
    requires layout;
    requires io;

    // Opens packages for JavaFX Reflection (Necessary for FXML and TableView)
    opens com.example.controller to javafx.fxml;
    //opens com.example.dto to javafx.base;

    // This is the important part for iText/Reflection
    opens com.example.dto to javafx.base, com.itextpdf.layout;
    
    // Exports packages to be accessible by other modules if needed
    exports com.example;
    exports com.example.controller;
    exports com.example.dto;
}