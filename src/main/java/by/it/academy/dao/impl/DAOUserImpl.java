package by.it.academy.dao.impl;

import by.it.academy.dao.config.DBCPDataSourceFactory;
import by.it.academy.beans.RegistrationInfo;
import by.it.academy.beans.User;
import by.it.academy.dao.DAOUser;
import by.it.academy.exeptions.DAOException;

import java.sql.*;
import java.util.List;

public class DAOUserImpl implements DAOUser {


    @Override
    public void registrationNewUser(RegistrationInfo info) throws DAOException {
        String SQLQuery = "insert into news_portal.user(name, surname, email, password, dateOfRegistration) " +
                "values (?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement prepStmt = null;
        try {
            connection = DBCPDataSourceFactory.getInstance().getConnection();
            prepStmt = connection.prepareStatement(SQLQuery);
            prepStmt.setString(1,info.getName());
            prepStmt.setString(2,info.getName());
            prepStmt.setString(3,info.getName());
            prepStmt.setString(4,info.getName());
            prepStmt.setString(5,"DATE_ADD(NOW())");
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            //log
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException exception) {
                //log
                exception.printStackTrace();
            }
        } finally {
            closeStatement(prepStmt);
            closeConnection(connection);
        }
    }

    @Override
    public User authorizationUser(String email, String password) throws DAOException {
        String SQLQuery = "SELECT * FROM news_portal.user WHERE email=? AND password=?";
        Connection connection = null;
        PreparedStatement prepStmt = null;
        ResultSet resultSet = null;
        try {
            connection = DBCPDataSourceFactory.getInstance().getConnection();
            prepStmt = connection.prepareStatement(SQLQuery);
            prepStmt.setString(1,email);
            prepStmt.setString(2,password);

            prepStmt.executeQuery();
        } catch (SQLException e) {
            //log
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException exception) {
                //log
                exception.printStackTrace();
            }
        } finally {
            closeStatement(prepStmt);
            closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public User update(User user) {
        return null;
    }
}
