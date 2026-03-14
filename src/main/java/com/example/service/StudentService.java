package com.example.service;

import com.example.dto.StudentDTO;
import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    boolean saveStudent(StudentDTO dto) throws SQLException;
    boolean updateStudent(StudentDTO dto) throws SQLException;
    boolean deleteStudent(String id) throws SQLException;
    List<StudentDTO> getAllStudents() throws SQLException;
    StudentDTO searchStudent(String id) throws SQLException;
}