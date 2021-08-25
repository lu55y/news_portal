package by.it.academy.dao.impl;

import by.it.academy.dao.config.DBCPDataSourceFactory;
import by.it.academy.bean.RegistrationInfo;
import by.it.academy.bean.User;
import by.it.academy.dao.DAOUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOUserImpl implements DAOUser {


    @Override
    public void registrationNewUser(RegistrationInfo info) {
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
    public User authorizationUser(String email, String password) {
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
        List<User> users = new ArrayList<>();
        String SQLQuery = "SELECT * FROM news_portal.user";
        Connection connection = null;
        PreparedStatement prepStmt = null;
        ResultSet resultSet = null;
        try {
            connection = DBCPDataSourceFactory.getInstance().getConnection();
            prepStmt = connection.prepareStatement(SQLQuery);
            resultSet=prepStmt.executeQuery();
            while (resultSet.next()){
                int id =resultSet.getInt(1);
                String name=resultSet.getString(2);
                String surname=resultSet.getString(3);
                String email=resultSet.getString(4);
                String password=resultSet.getString(5);
                String role=resultSet.getString(6);
                String dateOfRegistration=resultSet.getString(7);
                users.add(new User(id, name, surname, email, password, role, dateOfRegistration));
            }
            return users;
        } catch (SQLException e) {
            //log
            e.printStackTrace();
        } finally {
            closeStatement(prepStmt);
            closeConnection(connection);
        }
        return users;
    }

    @Override
    public User findById(Integer id) {
        User user;
        String SQLQuery = "SELECT * FROM news_portal.user WHERE id=?";
        Connection connection = null;
        PreparedStatement prepStmt = null;
        ResultSet resultSet = null;
        try {
            connection = DBCPDataSourceFactory.getInstance().getConnection();
            prepStmt=connection.prepareStatement(SQLQuery);
            prepStmt.setInt(1,id);
            resultSet= prepStmt.executeQuery();
            while (resultSet.next()){
                int userId =resultSet.getInt(1);
                String name=resultSet.getString(2);
                String surname=resultSet.getString(3);
                String email=resultSet.getString(4);
                String password=resultSet.getString(5);
                String role=resultSet.getString(6);
                String dateOfRegistration=resultSet.getString(7);
                user= new User(userId, name, surname, email, password, role, dateOfRegistration);
                return user;
            }
        } catch (SQLException e) {
            //log
            e.printStackTrace();
        } finally {
            closeStatement(prepStmt);
            closeConnection(connection);
        }
        return null;
    }

    @Override
    public boolean delete(User user) {
        String SQLQuery = "DELETE user FROM news_portal.user WHERE id=? and name=? and surname=? and email=?";
        Connection connection = null;
        PreparedStatement prepStmt = null;
        try{
            connection = DBCPDataSourceFactory.getInstance().getConnection();
            prepStmt=connection.prepareStatement(SQLQuery);
            prepStmt.setInt(1,user.getId());
            prepStmt.setString(2, user.getName());
            prepStmt.setString(3, user.getSurname());
            prepStmt.setString(4, user.getEmail());
            int i = prepStmt.executeUpdate();
            if (i>=1){
                return true;
            }connection.rollback();
        } catch (SQLException exception) {
            //log
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                //log
                throwables.printStackTrace();
            }
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String SQLQuery = "DELETE user FROM news_portal.user WHERE id=?";
        Connection connection = null;
        PreparedStatement prepStmt = null;
        try{
            connection = DBCPDataSourceFactory.getInstance().getConnection();
            prepStmt=connection.prepareStatement(SQLQuery);
            prepStmt.setInt(1,id);
            int i = prepStmt.executeUpdate();
            if (i>=1){
                return true;
            }connection.rollback();
        } catch (SQLException exception) {
            //log
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                //log
                throwables.printStackTrace();
            }
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean create(User user) {
        String SQLQuery = "INSERT into news_portal.user(id, name, surname, email, password)  " +
                "values (?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement prepStmt = null;
        try{
            connection = DBCPDataSourceFactory.getInstance().getConnection();
            prepStmt=connection.prepareStatement(SQLQuery);
            prepStmt.setInt(1,user.getId());
            prepStmt.setString(2, user.getName());
            prepStmt.setString(3, user.getSurname());
            prepStmt.setString(4, user.getEmail());
            prepStmt.setString(5, user.getEmail());
            int i = prepStmt.executeUpdate();
            if (i>=1){
                return true;
            }connection.rollback();
        } catch (SQLException e1) {
            //log
            try {
                connection.rollback();
            } catch (SQLException e) {
                //log
                e.printStackTrace();
            }
            e1.printStackTrace();
        }
        return false;
    }

    @Override
    public User update(User user) {
        return null;
    }
}
