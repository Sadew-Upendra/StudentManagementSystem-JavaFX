package com.example.dao;

import com.example.dao.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public StudentDAO getStudentDAO() {
        return new StudentDAOImpl();
    }
}