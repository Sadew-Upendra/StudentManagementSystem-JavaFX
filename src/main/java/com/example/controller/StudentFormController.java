package com.example.controller;

import com.example.dto.StudentDTO;
import com.example.service.impl.StudentServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class StudentFormController {

    @FXML private TableColumn<StudentDTO, String> colAddress;
    @FXML private TableColumn<StudentDTO, String> colContact;
    @FXML private TableColumn<StudentDTO, String> colEmail;
    @FXML private TableColumn<StudentDTO, String> colId;
    @FXML private TableColumn<StudentDTO, String> colName;
    @FXML private TableView<StudentDTO> tblStudent;
    @FXML private TextField txtAddress;
    @FXML private TextField txtContact;
    @FXML private TextField txtEmail;
    @FXML private TextField txtId;
    @FXML private TextField txtName;

    // Layered Architecture: Controller talks to Service
    private final StudentServiceImpl studentService = new StudentServiceImpl();

    /**
     * initialize() runs automatically when the FXML is loaded.
     */
    public void initialize() {
        // Set up Table Columns to match DTO field names
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        loadAllStudents();

        // Add listener to table for selecting a row
        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtId.setText(newValue.getId());
                txtName.setText(newValue.getName());
                txtEmail.setText(newValue.getEmail());
                txtContact.setText(newValue.getContact());
                txtAddress.setText(newValue.getAddress());
                txtId.setEditable(false); // ID shouldn't be edited during update
            }
        });
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        StudentDTO dto = new StudentDTO(
                txtId.getText(), txtName.getText(), txtEmail.getText(), 
                txtContact.getText(), txtAddress.getText()
        );

        try {
            if (studentService.saveStudent(dto)) {
                new Alert(Alert.AlertType.INFORMATION, "Student Saved!").show();
                loadAllStudents();
                btnClearOnAction(event);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        StudentDTO dto = new StudentDTO(
                txtId.getText(), txtName.getText(), txtEmail.getText(), 
                txtContact.getText(), txtAddress.getText()
        );

        try {
            if (studentService.updateStudent(dto)) {
                new Alert(Alert.AlertType.INFORMATION, "Student Updated!").show();
                loadAllStudents();
                btnClearOnAction(event);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();
        try {
            if (studentService.deleteStudent(id)) {
                new Alert(Alert.AlertType.INFORMATION, "Student Deleted!").show();
                loadAllStudents();
                btnClearOnAction(event);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtId.clear();
        txtName.clear();
        txtEmail.clear();
        txtContact.clear();
        txtAddress.clear();
        txtId.setEditable(true);
        tblStudent.getSelectionModel().clearSelection();
    }

    private void loadAllStudents() {
        try {
            List<StudentDTO> allStudents = studentService.getAllStudents();
            ObservableList<StudentDTO> obList = FXCollections.observableArrayList(allStudents);
            tblStudent.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}