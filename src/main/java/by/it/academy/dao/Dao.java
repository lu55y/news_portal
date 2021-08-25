package by.it.academy.dao;

import by.it.academy.bean.Entity;
import by.it.academy.exeptions.DAOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface Dao<K, T extends Entity> {

    List<T> findAll() throws DAOException;

    T findById(K id) throws DAOException;

    boolean delete(T t) throws DAOException;

    boolean delete(K id) throws DAOException;

    boolean create(T t) throws DAOException;

    T update(T t) throws DAOException;

    default void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            //log
            e.printStackTrace();
        }
    }

    default void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                //return connection to pool
                connection.close();
            }
        } catch (SQLException e) {
            //log
            e.printStackTrace();
        }
    }

}
