package com.example.util;

import com.example.dto.StudentDTO;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell; // Add this
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;

import java.io.FileNotFoundException;
import java.util.List;

public class ReportGenerator {

    public static void generateStudentReport(List<StudentDTO> studentList, String filePath) throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(filePath);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Header
        document.add(new Paragraph("Student Management System - Student Report")
                .setFontSize(20)
                .setBold());
        document.add(new Paragraph("Generated on: " + java.time.LocalDate.now()));
        document.add(new Paragraph("\n"));

        // Table with 5 columns
        float[] columnWidths = {1, 3, 4, 3, 4};
        Table table = new Table(UnitValue.createPercentArray(columnWidths));
        table.setWidth(UnitValue.createPercentValue(100));

        // Table Headers (Using Cell objects for better compatibility)
        table.addHeaderCell(new Cell().add(new Paragraph("ID").setBold()));
        table.addHeaderCell(new Cell().add(new Paragraph("Name").setBold()));
        table.addHeaderCell(new Cell().add(new Paragraph("Email").setBold()));
        table.addHeaderCell(new Cell().add(new Paragraph("Contact").setBold()));
        table.addHeaderCell(new Cell().add(new Paragraph("Address").setBold()));

        // Add Data with Null Checks
        for (StudentDTO student : studentList) {
            table.addCell(new Cell().add(new Paragraph(checkNull(student.getId()))));
            table.addCell(new Cell().add(new Paragraph(checkNull(student.getName()))));
            table.addCell(new Cell().add(new Paragraph(checkNull(student.getEmail()))));
            table.addCell(new Cell().add(new Paragraph(checkNull(student.getContact()))));
            table.addCell(new Cell().add(new Paragraph(checkNull(student.getAddress()))));
        }

        document.add(table);
        document.close();
    }

    // Helper method to prevent NullPointerExceptions
    private static String checkNull(String value) {
        return (value == null) ? "" : value;
    }
}