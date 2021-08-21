package by.it.academy.dao.config;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import by.it.academy.exeptions.DAOException;
import org.apache.commons.dbcp2.BasicDataSource;

public class DBCPDataSourceFactory {
    private static final DBCPDataSourceFactory instance=new DBCPDataSourceFactory();

    public static DBCPDataSourceFactory getInstance() {
        return instance;
    }

    private static DataSource getMySQLDataSource() {
        Properties props = new Properties();
        FileInputStream fileInputStream = null;
        BasicDataSource dataSource=new BasicDataSource();
        try {
            fileInputStream = new FileInputStream("db.properties");
            props.load(fileInputStream);
            dataSource.setDriverClassName(props.getProperty("MYSQL_DB_DRIVER_CLASS"));
            dataSource.setUrl(props.getProperty("MYSQL_DB_URL"));
            dataSource.setUsername(props.getProperty("MYSQL_DB_USERNAME"));
            dataSource.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
            dataSource.setMinIdle(5);
            dataSource.setMaxIdle(30);
        } catch (IOException e) {
            //log
            e.printStackTrace();
        }
        return dataSource;
    }
    public Connection getConnection(){
        try {
            return getMySQLDataSource().getConnection();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    void closeStatement(Statement statement){
        try {
            if (statement!=null) {
                statement.close();
            }
        } catch (SQLException e) {
            //log
            e.printStackTrace();
        }
    }
    void closeConnection(Connection connection){
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
