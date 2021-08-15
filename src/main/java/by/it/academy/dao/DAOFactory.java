package main.java.by.it.academy.dao;

import main.java.by.it.academy.exeptions.DAOException;
import main.java.by.it.academy.exeptions.DriverException;
import jakarta.servlet.ServletConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

    private static final String DRIVER = "org.gjt.mm.mysql.Driver";
    private static final String DB_PATH = "jdbc:mysql://127.0.0.1/news?useSSL=false";
    private static final String DB_LOGIN = "root";
    private static final String DB_PASSWORD = "root";


    private static DAOFactory daoFactory;

    private DAOFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DAOProvider getDaoImpl(ServletConfig config) throws SQLException {
        Connection connection = DriverManager.getConnection(
                config.getServletContext().getInitParameter(DB_PATH),
                config.getServletContext().getInitParameter(DB_LOGIN),
                config.getServletContext().getInitParameter(DB_PASSWORD)
        );
        return new DAOProvider(connection);
    }
}
