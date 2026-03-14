package com.example.dao;

import com.example.entity.StudentEntity;
import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    boolean save(StudentEntity entity) throws SQLException;
    boolean update(StudentEntity entity) throws SQLException;
    boolean delete(String id) throws SQLException;
    List<StudentEntity> getAll() throws SQLException;
    StudentEntity search(String id) throws SQLException;
}