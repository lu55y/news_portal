package by.it.academy.dao;

import by.it.academy.beans.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface Dao <K,T extends Entity> {

    List<T> findAll();
    T findEntityById(K id);
    boolean delete(T t);
    boolean delete(K id);
    boolean create(T t);
    T update(T t);

    default void closeStatement(Statement statement){
        try {
            if (statement!=null) {
                statement.close();
            }
        } catch (SQLException e) {
            //log
            e.printStackTrace();
        }
    }
    default void closeConnection(Connection connection){
        try {
            if (connection!=null) {
                //return connection to pool
                connection.close();
            }
        } catch (SQLException e) {
            //log
            e.printStackTrace();
        }
    }

}
