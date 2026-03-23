package com.example.controller;

import com.example.service.impl.StudentServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class DashboardFormController {

    @FXML private Label lblTotalStudents;
    @FXML private BarChart<String, Number> regChart;

    private final StudentServiceImpl studentService = new StudentServiceImpl();

    public void initialize() {
        loadMetrics();
        loadChart();
    }

    private void loadMetrics() {
        try {
            int count = studentService.getAllStudents().size();
            lblTotalStudents.setText(String.format("%02d", count));
        } catch (SQLException e) {
            lblTotalStudents.setText("0");
        }
    }

    private void loadChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("2026 Registrations");
        
        // Sample data for visualization
        series.getData().add(new XYChart.Data<>("Jan", 15));
        series.getData().add(new XYChart.Data<>("Feb", 25));
        series.getData().add(new XYChart.Data<>("Mar", 10));
        
        regChart.getData().add(series);
    }
}