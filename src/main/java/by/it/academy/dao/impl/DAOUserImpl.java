package by.it.academy.dao.impl;

import by.it.academy.bean.RegistrationInfo;
import by.it.academy.bean.User;
import by.it.academy.dao.DAOUser;
import by.it.academy.dao.config.ConnectionPool;
import by.it.academy.dao.exeption.ConnectionPoolException;
import by.it.academy.dao.exeption.DAOException;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class DAOUserImpl implements DAOUser {
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private static final ReentrantLock LOCKER=new ReentrantLock();
    private static final String REGISTER_NEW_USER = "INSERT INTO news_portal.user (name, surname, email, password, role, dateOfRegistration) values (?,?,?,?,DEFAULT,?)";
    private static final String FIND_ALL_USERS = "SELECT * FROM news_portal.user";
    private static final String USER_AUTHORIZATION = "SELECT * FROM news_portal.user WHERE email=? AND password=?";
    private static final String UPDATE_USER_INFORMATION = "UPDATE news_portal.user SET name=? and surname=? and email=? and password=? WHERE id=?";
    private static final String FIND_USER_BY_ID = "SELECT * FROM news_portal.user WHERE id=?";
    private static final String DELETE_BY_ID = "DELETE user FROM news_portal.user WHERE id=?";

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String USER_ID = "id";
    private static final String USER_NAME = "name";
    private static final String USER_SURNAME = "surname";
    private static final String USER_EMAIL = "email";
    private static final String USER_PASSWORD = "password";
    private static final String USER_ROLE = "role";
    private static final String USER_REG_DATE = "dateOfRegistration";


    @Override
    public User authorizationUser(String email, String password) throws DAOException {
        LOCKER.lock();
        ResultSet resultSet = null;
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(USER_AUTHORIZATION)) {
            prepStmt.setString(1, email);
            prepStmt.setString(2, password);
            resultSet = prepStmt.executeQuery();
            if (resultSet.wasNull()) {
                throw new DAOException("User authorization error.");
            }
            return new User(resultSet.getInt(USER_ID),
                    resultSet.getString(USER_NAME),
                    resultSet.getString(USER_SURNAME),
                    resultSet.getString(USER_EMAIL),
                    resultSet.getString(USER_PASSWORD),
                    resultSet.getString(USER_ROLE),
                    resultSet.getString(USER_REG_DATE));
        } catch (SQLException e) {
            //log
            throw new DAOException("User authorization error:", e);
        } catch (ConnectionPoolException e) {
            //log
            throw new DAOException("Connection error:", e);
        } finally {
            LOCKER.unlock();
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    //log
                    throw new DAOException("Close error:", e);
                }
            }
        }
    }

    @Override
    public List<User> findAll() throws DAOException {
        List<User> users = new ArrayList<>();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(FIND_ALL_USERS);
             ResultSet resultSet = prepStmt.executeQuery()) {
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt(USER_ID),
                        resultSet.getString(USER_NAME),
                        resultSet.getString(USER_SURNAME),
                        resultSet.getString(USER_EMAIL),
                        resultSet.getString(USER_PASSWORD),
                        resultSet.getString(USER_ROLE),
                        resultSet.getString(USER_REG_DATE)));
            }
            return users;
        } catch (SQLException e) {
            //log
            throw new DAOException("User search error:", e);
        } catch (ConnectionPoolException e) {
            //log
            throw new DAOException("Connection error:", e);
        }
    }

    @Override
    public User findById(Integer id) throws DAOException {
        ResultSet resultSet = null;
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(FIND_USER_BY_ID)) {
            prepStmt.setInt(1, id);
            resultSet = prepStmt.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getInt(USER_ID),
                        resultSet.getString(USER_NAME),
                        resultSet.getString(USER_SURNAME),
                        resultSet.getString(USER_EMAIL),
                        resultSet.getString(USER_PASSWORD),
                        resultSet.getString(USER_ROLE),
                        resultSet.getString(USER_REG_DATE));
            }
        } catch (SQLException e) {
            //log
            throw new DAOException("User search error:", e);
        } catch (ConnectionPoolException e) {
            //log
            throw new DAOException("Connection error:", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    //log
                    throw new DAOException("Close error:", e);
                }
            }
        }
        return null;
    }


    @Override
    public boolean deleteByID(Integer id) throws DAOException {
        LOCKER.lock();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(DELETE_BY_ID)) {
            prepStmt.setInt(1, id);
            int i = prepStmt.executeUpdate();
            if (i >= 1) return true;
        } catch (SQLException e) {
            //log
            throw new DAOException("User deleting error:", e);
        } catch (ConnectionPoolException e) {
            //log
            throw new DAOException("Connection error:", e);
        } finally {
            LOCKER.unlock();
        }
        return false;
    }

    @Override
    public boolean create(RegistrationInfo info) throws DAOException {
        LOCKER.lock();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(REGISTER_NEW_USER)) {
            prepStmt.setString(1, info.getName());
            prepStmt.setString(2, info.getSurname());
            prepStmt.setString(3, info.getEmail());
            prepStmt.setString(4, info.getPassword());
            prepStmt.setString(5, getDate());
            int i = prepStmt.executeUpdate();
            if (i >= 1) return true;
        } catch (SQLException e) {
            //log
            throw new DAOException("User registration error:", e);
        } catch (ConnectionPoolException e) {
            //log
            throw new DAOException("Connection error:", e);
        } finally {
            LOCKER.unlock();
        }
        return false;
    }

    @Override
    public boolean update(User user) throws DAOException {
        LOCKER.lock();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(UPDATE_USER_INFORMATION)) {
            prepStmt.setString(1, user.getName());
            prepStmt.setString(2, user.getSurname());
            prepStmt.setString(3, user.getEmail());
            prepStmt.setString(4, user.getPassword());
            prepStmt.setInt(5, user.getId());
            int i = prepStmt.executeUpdate();
            if (i >= 1) return true;
        } catch (SQLException e) {
            //log
            throw new DAOException("User update error:", e);
        } catch (ConnectionPoolException e) {
            //log
            throw new DAOException("Connection error:", e);
        } finally {
            LOCKER.unlock();
        }
        return false;
    }

    private String getDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(date);
    }
}
