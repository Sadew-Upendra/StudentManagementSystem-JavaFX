package com.example.controller;

import com.example.dto.StudentDTO;
import com.example.service.impl.StudentServiceImpl;
import com.example.util.ReportGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class ReportFormController {

    private final StudentServiceImpl studentService = new StudentServiceImpl();

    @FXML
    void btnGeneratePdfOnAction(ActionEvent event) {
        try {
            List<StudentDTO> studentList = studentService.getAllStudents();
            
            if (studentList.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "No student data available to generate a report.").show();
                return;
            }

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Student Report");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
            fileChooser.setInitialFileName("Student_Master_Report.pdf");
            
            File file = fileChooser.showSaveDialog(null);

            if (file != null) {
                ReportGenerator.generateStudentReport(studentList, file.getAbsolutePath());
                new Alert(Alert.AlertType.INFORMATION, "PDF Report created successfully at: " + file.getName()).show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error generating report: " + e.getMessage()).show();
            e.printStackTrace();
        }
    }
}