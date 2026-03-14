package com.example.service.impl;

import com.example.dao.impl.StudentDAOImpl;
import com.example.dto.StudentDTO;
import com.example.entity.StudentEntity;
import com.example.service.StudentService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    // Dependency on DAO Layer
    private final StudentDAOImpl studentDAO = new StudentDAOImpl();

    @Override
    public boolean saveStudent(StudentDTO dto) throws SQLException {
        // Converting DTO to Entity before passing to DAO
        return studentDAO.save(new StudentEntity(
                dto.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getContact(),
                dto.getAddress()
        ));
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws SQLException {
        return studentDAO.update(new StudentEntity(
                dto.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getContact(),
                dto.getAddress()
        ));
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException {
        return studentDAO.delete(id);
    }

    @Override
    public List<StudentDTO> getAllStudents() throws SQLException {
        List<StudentEntity> allEntities = studentDAO.getAll();
        List<StudentDTO> allDTOs = new ArrayList<>();

        // Converting list of Entities back to DTOs for the UI
        for (StudentEntity entity : allEntities) {
            allDTOs.add(new StudentDTO(
                    entity.getId(),
                    entity.getName(),
                    entity.getEmail(),
                    entity.getContact(),
                    entity.getAddress()
            ));
        }
        return allDTOs;
    }

    @Override
    public StudentDTO searchStudent(String id) throws SQLException {
        StudentEntity entity = studentDAO.search(id);
        if (entity != null) {
            return new StudentDTO(
                    entity.getId(),
                    entity.getName(),
                    entity.getEmail(),
                    entity.getContact(),
                    entity.getAddress()
            );
        }
        return null;
    }
}