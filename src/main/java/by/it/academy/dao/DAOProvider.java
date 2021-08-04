package by.it.academy.dao;

import by.it.academy.dao.impl.DAONewsImpl;
import by.it.academy.dao.impl.DAOUserImpl;

import java.sql.Connection;

public class DAOProvider {
    private static Connection connection;
    public static final DAOProvider INSTANCE = new DAOProvider(connection);
    private final DAOUser daoUser = new DAOUserImpl();
    private final DAONews daoNews = new DAONewsImpl();

    public DAOProvider(Connection connection) {
    }

    public static DAOProvider getINSTANCE() {
        return INSTANCE;
    }

    public DAOUser getDaoUser() {
        return daoUser;
    }

    public DAONews getDaoNews() {
        return daoNews;
    }
}
