package com.example.dao.impl;

import com.example.dao.StudentDAO;
import com.example.db.DBConnection;
import com.example.entity.StudentEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean save(StudentEntity entity) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO student (id, name, email, contact, address) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, entity.getId());
        pstm.setString(2, entity.getName());
        pstm.setString(3, entity.getEmail());
        pstm.setString(4, entity.getContact());
        pstm.setString(5, entity.getAddress());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(StudentEntity entity) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE student SET name=?, email=?, contact=?, address=? WHERE id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, entity.getName());
        pstm.setString(2, entity.getEmail());
        pstm.setString(3, entity.getContact());
        pstm.setString(4, entity.getAddress());
        pstm.setString(5, entity.getId());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM student WHERE id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public List<StudentEntity> getAll() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM student";
        Statement stmt = connection.createStatement();
        ResultSet rst = stmt.executeQuery(sql);
        
        List<StudentEntity> studentList = new ArrayList<>();
        while (rst.next()) {
            studentList.add(new StudentEntity(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("email"),
                    rst.getString("contact"),
                    rst.getString("address")
            ));
        }
        return studentList;
    }

    @Override
    public StudentEntity search(String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM student WHERE id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);
        ResultSet rst = pstm.executeQuery();
        
        if (rst.next()) {
            return new StudentEntity(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("email"),
                    rst.getString("contact"),
                    rst.getString("address")
            );
        }
        return null;
    }
}